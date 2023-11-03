package io.atha.utils

import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.nio.BufferOverflowException
import kotlin.math.min

/**
 * Implements the Circular Buffer producer/consumer model for bytes.
 * More information about this class is available from [ostermiller.org](http://ostermiller.org/utils/CircularByteBuffer.html).
 *
 *
 * Using this class is a simpler alternative to using a PipedInputStream
 * and a PipedOutputStream. PipedInputStreams and PipedOutputStreams don't support the
 * mark operation, don't allow you to control buffer sizes that they use,
 * and have a more complicated API that requires instantiating two
 * classes and connecting them.
 *
 *
 * This class is thread safe.
 *
 * @author Stephen Ostermiller http://ostermiller.org/contact.pl?regarding=Java+Utilities
 * @since ostermillerutils 1.00.00
 */
class CircularByteBuffer @JvmOverloads constructor(
    size: Int = DEFAULT_SIZE,
    blockingWrite: Boolean = true
) {
    /**
     * The circular buffer.
     *
     *
     * The actual capacity of the buffer is one less than the actual length
     * of the buffer so that an empty and a full buffer can be
     * distinguished.  An empty buffer will have the markPostion and the
     * writePosition equal to each other.  A full buffer will have
     * the writePosition one less than the markPostion.
     *
     *
     * There are three important indexes into the buffer:
     * The readPosition, the writePosition, and the markPosition.
     * If the InputStream has never been marked, the readPosition and
     * the markPosition should always be the same.  The bytes
     * available to be read go from the readPosition to the writePosition,
     * wrapping around the end of the buffer.  The space available for writing
     * goes from the write position to one less than the markPosition,
     * wrapping around the end of the buffer.  The bytes that have
     * been saved to support a reset() of the InputStream go from markPosition
     * to readPosition, wrapping around the end of the buffer.
     *
     * @since ostermillerutils 1.00.00
     */
    private var buffer: ByteArray

    /**
     * Index of the first byte available to be read.
     *
     * @since ostermillerutils 1.00.00
     */
    @Volatile
    private var readPosition = 0

    /**
     * Index of the first byte available to be written.
     *
     * @since ostermillerutils 1.00.00
     */
    @Volatile
    private var writePosition = 0

    /**
     * Index of the first saved byte. (To support stream marking.)
     *
     * @since ostermillerutils 1.00.00
     */
    @Volatile
    private var markPosition = 0

    /**
     * Number of bytes that have to be saved
     * to support mark() and reset() on the InputStream.
     *
     * @since ostermillerutils 1.00.00
     */
    @Volatile
    private var markSize = 0

    /**
     * If this buffer is infinite (should resize itself when full)
     *
     * @since ostermillerutils 1.00.00
     */
    @Volatile
    private var infinite = false

    /**
     * True if a write to a full buffer should block until the buffer
     * has room, false if the write method should throw an IOException
     *
     * @since ostermillerutils 1.00.00
     */
    private var blockingWrite = true
    /**
     * Retrieve a InputStream that can be used to empty
     * this buffer.
     *
     *
     * This InputStream supports marks at the expense
     * of the buffer size.
     *
     * @return the consumer for this buffer.
     *
     * @since ostermillerutils 1.00.00
     */
    /**
     * The InputStream that can empty this buffer.
     *
     * @since ostermillerutils 1.00.00
     */
    var inputStream: InputStream = CircularByteBufferInputStream()
        private set

    /**
     * true if the close() method has been called on the InputStream
     *
     * @since ostermillerutils 1.00.00
     */
    private var inputStreamClosed = false
    /**
     * Retrieve a OutputStream that can be used to fill
     * this buffer.
     *
     *
     * Write methods may throw a BufferOverflowException if
     * the buffer is not large enough.  A large enough buffer
     * size must be chosen so that this does not happen or
     * the caller must be prepared to catch the exception and
     * try again once part of the buffer has been consumed.
     *
     *
     * @return the producer for this buffer.
     *
     * @since ostermillerutils 1.00.00
     */
    /**
     * The OutputStream that can fill this buffer.
     *
     * @since ostermillerutils 1.00.00
     */
    var outputStream: OutputStream = CircularByteBufferOutputStream()
        private set

    /**
     * true if the close() method has been called on the OutputStream
     *
     * @since ostermillerutils 1.00.00
     */
    private var outputStreamClosed = false

    /**
     * Make this buffer ready for reuse.  The contents of the buffer
     * will be cleared and the streams associated with this buffer
     * will be reopened if they had been closed.
     *
     * @since ostermillerutils 1.00.00
     */
    fun clear() {
        synchronized(this) {
            readPosition = 0
            writePosition = 0
            markPosition = 0
            outputStreamClosed = false
            inputStreamClosed = false
        }
    }

    val available: Int
        /**
         * Get number of bytes that are available to be read.
         *
         *
         * Note that the number of bytes available plus
         * the number of bytes free may not add up to the
         * capacity of this buffer, as the buffer may reserve some
         * space for other purposes.
         *
         * @return the size in bytes of this buffer
         *
         * @since ostermillerutils 1.00.00
         */
        get() {
            synchronized(this) { return available() }
        }
    val spaceLeft: Int
        /**
         * Get the number of bytes this buffer has free for
         * writing.
         *
         *
         * Note that the number of bytes available plus
         * the number of bytes free may not add up to the
         * capacity of this buffer, as the buffer may reserve some
         * space for other purposes.
         *
         * @return the available space in bytes of this buffer
         *
         * @since ostermillerutils 1.00.00
         */
        get() {
            synchronized(this) { return spaceLeft() }
        }
    val size: Int
        /**
         * Get the capacity of this buffer.
         *
         *
         * Note that the number of bytes available plus
         * the number of bytes free may not add up to the
         * capacity of this buffer, as the buffer may reserve some
         * space for other purposes.
         *
         * @return the size in bytes of this buffer
         *
         * @since ostermillerutils 1.00.00
         */
        get() {
            synchronized(this) { return buffer.size }
        }

    /**
     * double the size of the buffer
     *
     * @since ostermillerutils 1.00.00
     */
    private fun resize() {
        val newBuffer = ByteArray(buffer.size * 2)
        val marked = marked()
        val available = available()
        if (markPosition <= writePosition) {
            // any space between the mark and
            // the first write needs to be saved.
            // In this case it is all in one piece.
            val length = writePosition - markPosition
            System.arraycopy(buffer, markPosition, newBuffer, 0, length)
        } else {
            val length1 = buffer.size - markPosition
            System.arraycopy(buffer, markPosition, newBuffer, 0, length1)
            val length2 = writePosition
            System.arraycopy(buffer, 0, newBuffer, length1, length2)
        }
        buffer = newBuffer
        markPosition = 0
        readPosition = marked
        writePosition = marked + available
    }

    /**
     * Space available in the buffer which can be written.
     *
     * @since ostermillerutils 1.00.00
     */
    private fun spaceLeft(): Int {
        return if (writePosition < markPosition) {
            // any space between the first write and
            // the mark except one byte is available.
            // In this case it is all in one piece.
            markPosition - writePosition - 1
        } else buffer.size - 1 - (writePosition - markPosition)
        // space at the beginning and end.
    }

    /**
     * Bytes available for reading.
     *
     * @since ostermillerutils 1.00.00
     */
    private fun available(): Int {
        return if (readPosition <= writePosition) {
            // any space between the first read and
            // the first write is available.  In this case i
            // is all in one piece.
            writePosition - readPosition
        } else buffer.size - (readPosition - writePosition)
        // space at the beginning and end.
    }

    /**
     * Bytes saved for supporting marks.
     *
     * @since ostermillerutils 1.00.00
     */
    private fun marked(): Int {
        return if (markPosition <= readPosition) {
            // any space between the markPosition and
            // the first write is marked.  In this case i
            // is all in one piece.
            readPosition - markPosition
        } else buffer.size - (markPosition - readPosition)
        // space at the beginning and end.
    }

    /**
     * If we have passed the markSize reset the
     * mark so that the space can be used.
     *
     * @since ostermillerutils 1.00.00
     */
    private fun ensureMark() {
        if (marked() > markSize) {
            markPosition = readPosition
            markSize = 0
        }
    }

    /**
     * Create a new buffer with a default capacity and
     * given blocking behavior.
     *
     * @param blockingWrite true writing to a full buffer should block
     * until space is available, false if an exception should
     * be thrown instead.
     *
     * @since ostermillerutils 1.00.00
     */
    constructor(blockingWrite: Boolean) : this(DEFAULT_SIZE, blockingWrite)
    /**
     * Create a new buffer with the given capacity and
     * blocking behavior.
     *
     *
     * Note that the buffer may reserve some bytes for
     * special purposes and capacity number of bytes may
     * not be able to be written to the buffer.
     *
     *
     * Note that if the buffer is of INFINITE_SIZE it will
     * neither block or throw exceptions, but rather grow
     * without bound.
     *
     * @param size desired capacity of the buffer in bytes or CircularByteBuffer.INFINITE_SIZE.
     * @param blockingWrite true writing to a full buffer should block
     * until space is available, false if an exception should
     * be thrown instead.
     *
     * @since ostermillerutils 1.00.00
     */
    /**
     * Create a new buffer with a default capacity.
     * Writing to a full buffer will block until space
     * is available rather than throw an exception.
     *
     * @since ostermillerutils 1.00.00
     */
    /**
     * Create a new buffer with given capacity.
     * Writing to a full buffer will block until space
     * is available rather than throw an exception.
     *
     *
     * Note that the buffer may reserve some bytes for
     * special purposes and capacity number of bytes may
     * not be able to be written to the buffer.
     *
     *
     * Note that if the buffer is of INFINITE_SIZE it will
     * neither block or throw exceptions, but rather grow
     * without bound.
     *
     * @param size desired capacity of the buffer in bytes or CircularByteBuffer.INFINITE_SIZE.
     *
     * @since ostermillerutils 1.00.00
     */
    init {
        if (size == INFINITE_SIZE) {
            buffer = ByteArray(DEFAULT_SIZE)
            infinite = true
        } else {
            buffer = ByteArray(size)
            infinite = false
        }
        this.blockingWrite = blockingWrite
    }

    /**
     * Class for reading from a circular byte buffer.
     *
     * @since ostermillerutils 1.00.00
     */
    private inner class CircularByteBufferInputStream : InputStream() {
        /**
         * Returns the number of bytes that can be read (or skipped over) from this
         * input stream without blocking by the next caller of a method for this input
         * stream. The next caller might be the same thread or or another thread.
         *
         * @return the number of bytes that can be read from this input stream without blocking.
         * @throws IOException if the stream is closed.
         *
         * @since ostermillerutils 1.00.00
         */
        @Throws(IOException::class)
        override fun available(): Int {
            synchronized(this@CircularByteBuffer) {
                if (inputStreamClosed) throw IOException("InputStream has been closed, it is not ready.")
                return this@CircularByteBuffer.available()
            }
        }

        /**
         * Close the stream. Once a stream has been closed, further read(), available(),
         * mark(), or reset() invocations will throw an IOException. Closing a
         * previously-closed stream, however, has no effect.
         *
         * @throws IOException never.
         *
         * @since ostermillerutils 1.00.00
         */
        @Throws(IOException::class)
        override fun close() {
            synchronized(this@CircularByteBuffer) { inputStreamClosed = true }
        }

        /**
         * Mark the present position in the stream. Subsequent calls to reset() will
         * attempt to reposition the stream to this point.
         *
         *
         * The readAheadLimit must be less than the size of circular buffer, otherwise
         * this method has no effect.
         *
         * @param readAheadLimit Limit on the number of bytes that may be read while
         * still preserving the mark. After reading this many bytes, attempting to
         * reset the stream will fail.
         *
         * @since ostermillerutils 1.00.00
         */
        override fun mark(readAheadLimit: Int) {
            synchronized(this@CircularByteBuffer) {
                //if (inputStreamClosed) throw new IOException("InputStream has been closed; cannot mark a closed InputStream.");
                if (buffer.size - 1 > readAheadLimit) {
                    markSize = readAheadLimit
                    markPosition = readPosition
                }
            }
        }

        /**
         * Tell whether this stream supports the mark() operation.
         *
         * @return true, mark is supported.
         *
         * @since ostermillerutils 1.00.00
         */
        override fun markSupported(): Boolean {
            return true
        }

        /**
         * Read a single byte.
         * This method will block until a byte is available, an I/O error occurs,
         * or the end of the stream is reached.
         *
         * @return The byte read, as an integer in the range 0 to 255 (0x00-0xff),
         * or -1 if the end of the stream has been reached
         * @throws IOException if the stream is closed.
         *
         * @since ostermillerutils 1.00.00
         */
        @Throws(IOException::class)
        override fun read(): Int {
            while (true) {
                synchronized(this@CircularByteBuffer) {
                    if (inputStreamClosed) throw IOException("InputStream has been closed; cannot read from a closed InputStream.")
                    val available = this@CircularByteBuffer.available()
                    if (available > 0) {
                        val result = buffer[readPosition].toInt() and 0xff
                        readPosition++
                        if (readPosition == buffer.size) {
                            readPosition = 0
                        }
                        ensureMark()
                        return result
                    } else if (outputStreamClosed) {
                        return -1
                    }
                }
                try {
                    Thread.sleep(100)
                } catch (x: java.lang.Exception) {
                    throw IOException("Blocking read operation interrupted.")
                }
            }
        }

        /**
         * Read bytes into an array.
         * This method will block until some input is available,
         * an I/O error occurs, or the end of the stream is reached.
         *
         * @param cbuf Destination buffer.
         * @return The number of bytes read, or -1 if the end of
         * the stream has been reached
         * @throws IOException if the stream is closed.
         *
         * @since ostermillerutils 1.00.00
         */
        @Throws(IOException::class)
        override fun read(cbuf: ByteArray): Int {
            return read(cbuf, 0, cbuf.size)
        }

        /**
         * Read bytes into a portion of an array.
         * This method will block until some input is available,
         * an I/O error occurs, or the end of the stream is reached.
         *
         * @param cbuf Destination buffer.
         * @param off Offset at which to start storing bytes.
         * @param len Maximum number of bytes to read.
         * @return The number of bytes read, or -1 if the end of
         * the stream has been reached
         * @throws IOException if the stream is closed.
         *
         * @since ostermillerutils 1.00.00
         */
        @Throws(IOException::class)
        override fun read(cbuf: ByteArray, off: Int, len: Int): Int {
            while (true) {
                synchronized(this@CircularByteBuffer) {
                    if (inputStreamClosed) throw IOException("InputStream has been closed; cannot read from a closed InputStream.")
                    val available = this@CircularByteBuffer.available()
                    if (available > 0) {
                        val length = min(len, available)
                        val firstLen =
                            min(length, buffer.size - readPosition)
                        val secondLen = length - firstLen
                        System.arraycopy(buffer, readPosition, cbuf, off, firstLen)
                        if (secondLen > 0) {
                            System.arraycopy(buffer, 0, cbuf, off + firstLen, secondLen)
                            readPosition = secondLen
                        } else {
                            readPosition += length
                        }
                        if (readPosition == buffer.size) {
                            readPosition = 0
                        }
                        ensureMark()
                        return length
                    } else if (outputStreamClosed) {
                        return -1
                    }
                }
                try {
                    Thread.sleep(100)
                } catch (x: java.lang.Exception) {
                    throw IOException("Blocking read operation interrupted.")
                }
            }
        }

        /**
         * Reset the stream.
         * If the stream has been marked, then attempt to reposition i
         * at the mark. If the stream has not been marked, or more bytes
         * than the readAheadLimit have been read, this method has no effect.
         *
         * @throws IOException if the stream is closed.
         *
         * @since ostermillerutils 1.00.00
         */
        @Throws(IOException::class)
        override fun reset() {
            synchronized(this@CircularByteBuffer) {
                if (inputStreamClosed) throw IOException("InputStream has been closed; cannot reset a closed InputStream.")
                readPosition = markPosition
            }
        }

        /**
         * Skip bytes.
         * This method will block until some bytes are available,
         * an I/O error occurs, or the end of the stream is reached.
         *
         * @param n The number of bytes to skip
         * @return The number of bytes actually skipped
         * @throws IllegalArgumentException if n is negative.
         * @throws IOException if the stream is closed.
         *
         * @since ostermillerutils 1.00.00
         */
        @Throws(IOException::class, IllegalArgumentException::class)
        override fun skip(n: Long): Long {
            while (true) {
                synchronized(this@CircularByteBuffer) {
                    if (inputStreamClosed) throw IOException("InputStream has been closed; cannot skip bytes on a closed InputStream.")
                    val available = this@CircularByteBuffer.available()
                    if (available > 0) {
                        val length = min(n.toInt(), available)
                        val firstLen =
                            min(length, buffer.size - readPosition)
                        val secondLen = length - firstLen
                        if (secondLen > 0) {
                            readPosition = secondLen
                        } else {
                            readPosition += length
                        }
                        if (readPosition == buffer.size) {
                            readPosition = 0
                        }
                        ensureMark()
                        return length.toLong()
                    } else if (outputStreamClosed) {
                        return 0
                    }
                }
                try {
                    Thread.sleep(100)
                } catch (x: java.lang.Exception) {
                    throw IOException("Blocking read operation interrupted.")
                }
            }
        }
    }

    /**
     * Class for writing to a circular byte buffer.
     * If the buffer is full, the writes will either block
     * until there is some space available or throw an IOException
     * based on the CircularByteBuffer's preference.
     *
     * @since ostermillerutils 1.00.00
     */
    private inner class CircularByteBufferOutputStream : OutputStream() {
        /**
         * Close the stream, flushing it first.
         * This will cause the InputStream associated with this circular buffer
         * to read its last bytes once it empties the buffer.
         * Once a stream has been closed, further write() or flush() invocations
         * will cause an IOException to be thrown. Closing a previously-closed stream,
         * however, has no effect.
         *
         * @throws IOException never.
         *
         * @since ostermillerutils 1.00.00
         */
        @Throws(IOException::class)
        override fun close() {
            synchronized(this@CircularByteBuffer) {
                if (!outputStreamClosed) {
                    flush()
                }
                outputStreamClosed = true
            }
        }

        /**
         * Flush the stream.
         *
         * @throws IOException if the stream is closed.
         *
         * @since ostermillerutils 1.00.00
         */
        @Throws(IOException::class)
        override fun flush() {
            synchronized(this@CircularByteBuffer) {
                if (outputStreamClosed) throw IOException("OutputStream has been closed; cannot flush a closed OutputStream.")
                if (inputStreamClosed) throw IOException("Buffer closed by inputStream; cannot flush.")
            }
            // this method needs to do nothing
        }

        /**
         * Write an array of bytes.
         * If the buffer allows blocking writes, this method will block until
         * all the data has been written rather than throw an IOException.
         *
         * @param cbuf Array of bytes to be written
         * @throws BufferOverflowException if buffer does not allow blocking writes
         * and the buffer is full.  If the exception is thrown, no data
         * will have been written since the buffer was set to be non-blocking.
         * @throws IOException if the stream is closed, or the write is interrupted.
         *
         * @since ostermillerutils 1.00.00
         */
        @Throws(IOException::class)
        override fun write(cbuf: ByteArray) {
            write(cbuf, 0, cbuf.size)
        }

        /**
         * Write a portion of an array of bytes.
         * If the buffer allows blocking writes, this method will block until
         * all the data has been written rather than throw an IOException.
         *
         * @param cbuf Array of bytes
         * @param off Offset from which to start writing bytes
         * @param len - Number of bytes to write
         * @throws BufferOverflowException if buffer does not allow blocking writes
         * and the buffer is full.  If the exception is thrown, no data
         * will have been written since the buffer was set to be non-blocking.
         * @throws IOException if the stream is closed, or the write is interrupted.
         *
         * @since ostermillerutils 1.00.00
         */
        @Throws(IOException::class)
        override fun write(cbuf: ByteArray, off: Int, len: Int) {
            @Suppress("NAME_SHADOWING") var off = off
            @Suppress("NAME_SHADOWING") var len = len
            while (len > 0) {
                synchronized(this@CircularByteBuffer) {
                    if (outputStreamClosed) throw IOException("OutputStream has been closed; cannot write to a closed OutputStream.")
                    if (inputStreamClosed) throw IOException("Buffer closed by InputStream; cannot write to a closed buffer.")
                    var spaceLeft = spaceLeft()
                    while (infinite && spaceLeft < len) {
                        resize()
                        spaceLeft = spaceLeft()
                    }
                    if (!blockingWrite && spaceLeft < len) throw BufferOverflowException()
                    val realLen = min(len, spaceLeft)
                    val firstLen =
                        min(realLen, buffer.size - writePosition)
                    val secondLen =
                        min(realLen - firstLen, buffer.size - markPosition - 1)
                    val written = firstLen + secondLen
                    if (firstLen > 0) {
                        System.arraycopy(cbuf, off, buffer, writePosition, firstLen)
                    }
                    if (secondLen > 0) {
                        System.arraycopy(cbuf, off + firstLen, buffer, 0, secondLen)
                        writePosition = secondLen
                    } else {
                        writePosition += written
                    }
                    if (writePosition == buffer.size) {
                        writePosition = 0
                    }
                    off += written
                    len -= written
                }
                if (len > 0) {
                    try {
                        Thread.sleep(100)
                    } catch (x: java.lang.Exception) {
                        throw IOException("Waiting for available space in buffer interrupted.")
                    }
                }
            }
        }

        /**
         * Write a single byte.
         * The byte to be written is contained in the 8 low-order bits of the
         * given integer value; the 24 high-order bits are ignored.
         * If the buffer allows blocking writes, this method will block until
         * all the data has been written rather than throw an IOException.
         *
         * @param c number of bytes to be written
         * @throws BufferOverflowException if buffer does not allow blocking writes
         * and the buffer is full.
         * @throws IOException if the stream is closed, or the write is interrupted.
         *
         * @since ostermillerutils 1.00.00
         */
        @Throws(IOException::class)
        override fun write(c: Int) {
            var written = false
            while (!written) {
                synchronized(this@CircularByteBuffer) {
                    if (outputStreamClosed) throw IOException("OutputStream has been closed; cannot write to a closed OutputStream.")
                    if (inputStreamClosed) throw IOException("Buffer closed by InputStream; cannot write to a closed buffer.")
                    var spaceLeft = spaceLeft()
                    while (infinite && spaceLeft < 1) {
                        resize()
                        spaceLeft = spaceLeft()
                    }
                    if (!blockingWrite && spaceLeft < 1) throw BufferOverflowException()
                    if (spaceLeft > 0) {
                        buffer[writePosition] = (c and 0xff).toByte()
                        writePosition++
                        if (writePosition == buffer.size) {
                            writePosition = 0
                        }
                        written = true
                    }
                }
                if (!written) {
                    try {
                        Thread.sleep(100)
                    } catch (x: java.lang.Exception) {
                        throw IOException("Waiting for available space in buffer interrupted.")
                    }
                }
            }
        }
    }

    companion object {
        /**
         * The default size for a circular byte buffer.
         *
         * @since ostermillerutils 1.00.00
         */
        private const val DEFAULT_SIZE = 1024

        /**
         * A buffer that will grow as things are added.
         *
         * @since ostermillerutils 1.00.00
         */
        const val INFINITE_SIZE = -1
    }
}