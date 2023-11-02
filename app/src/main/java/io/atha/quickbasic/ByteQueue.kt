package io.atha.quickbasic

/** A circular byte buffer allowing one producer and one consumer thread.  */
class ByteQueue(size: Int) : Object() {
    private val mBuffer: ByteArray
    private var mHead = 0
    private var mStoredBytes = 0
    private var mOpen = true

    init {
        mBuffer = ByteArray(size)
    }

    @Synchronized
    fun close() {
        mOpen = false
        notify()
    }

    @Synchronized
    fun read(buffer: ByteArray, block: Boolean): Int {
        var totalRead = 0
        synchronized(this) {
            while (mStoredBytes == 0 && mOpen) {
                if (block) {
                    try {
                        wait()
                    } catch (e: InterruptedException) {
                        // Ignore.
                    }
                } else {
                    return 0
                }
            }
            if (!mOpen) return -1
            val bufferLength = mBuffer.size
            val wasFull = bufferLength == mStoredBytes
            var length = buffer.size
            var offset = 0
            while (length > 0 && mStoredBytes > 0) {
                val oneRun = Math.min(bufferLength - mHead, mStoredBytes)
                val bytesToCopy = Math.min(length, oneRun)
                System.arraycopy(mBuffer, mHead, buffer, offset, bytesToCopy)
                mHead += bytesToCopy
                if (mHead >= bufferLength) mHead = 0
                mStoredBytes -= bytesToCopy
                length -= bytesToCopy
                offset += bytesToCopy
                totalRead += bytesToCopy
            }
            if (wasFull) notify()
        }
        return totalRead
    }

    /**
     * Attempt to write the specified portion of the provided buffer to the queue.
     *
     *
     * Returns whether the output was totally written, false if it was closed before.
     */
    fun write(buffer: ByteArray, offset: Int, lengthToWrite: Int): Boolean {
        var offset = offset
        var lengthToWrite = lengthToWrite
        require(lengthToWrite + offset <= buffer.size) { "length + offset > buffer.length" }
        require(lengthToWrite > 0) { "length <= 0" }
        val bufferLength = mBuffer.size
        synchronized(this) {
            while (lengthToWrite > 0) {
                while (bufferLength == mStoredBytes && mOpen) {
                    try {
                        wait()
                    } catch (e: InterruptedException) {
                        // Ignore.
                    }
                }
                if (!mOpen) return false
                val wasEmpty = mStoredBytes == 0
                var bytesToWriteBeforeWaiting = Math.min(lengthToWrite, bufferLength - mStoredBytes)
                lengthToWrite -= bytesToWriteBeforeWaiting
                while (bytesToWriteBeforeWaiting > 0) {
                    var tail = mHead + mStoredBytes
                    var oneRun: Int
                    if (tail >= bufferLength) {
                        // Buffer: [.............]
                        // ________________H_______T
                        // =>
                        // Buffer: [.............]
                        // ___________T____H
                        // onRun= _____----_
                        tail = tail - bufferLength
                        oneRun = mHead - tail
                    } else {
                        oneRun = bufferLength - tail
                    }
                    val bytesToCopy = Math.min(oneRun, bytesToWriteBeforeWaiting)
                    System.arraycopy(buffer, offset, mBuffer, tail, bytesToCopy)
                    offset += bytesToCopy
                    bytesToWriteBeforeWaiting -= bytesToCopy
                    mStoredBytes += bytesToCopy
                }
                if (wasEmpty) notify()
            }
        }
        return true
    }
}