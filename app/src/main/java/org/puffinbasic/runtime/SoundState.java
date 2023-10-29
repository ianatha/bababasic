package org.puffinbasic.runtime;

public class SoundState implements AutoCloseable {

//    private static final class ClipState implements AutoCloseable {
//        final AudioInputStream stream;
//        final Clip clip;
//
//        ClipState(AudioInputStream stream, Clip clip) {
//            this.stream = stream;
//            this.clip = clip;
//        }
//
//        @Override
//        public void close() throws Exception {
//            clip.close();
//            stream.close();
//        }
//    }

//    private final ExecutorService executor;
//    private final AtomicInteger counter;
//    private final Int2ObjectMap<ClipState> state;

    SoundState() {
//        this.executor = Executors.newSingleThreadExecutor();
//        this.counter = new AtomicInteger();
//        this.state = new Int2ObjectOpenHashMap<>();
    }

    public int load(String file) {
//        var future = executor.submit(() -> {
//            var audioFile = new File(file);
//            final AudioInputStream audioStream;
//            try {
//                audioStream = AudioSystem.getAudioInputStream(audioFile);
//            } catch (Exception e) {
//                throw new PuffinBasicRuntimeError(
//                        IO_ERROR,
//                        "Failed to load audio file: " + file + ", error: " + e.getMessage()
//                );
//            }
//            var format = audioStream.getFormat();
//            var info = new DataLine.Info(Clip.class, format);
//            final Clip clip;
//            try {
//                clip = (Clip) AudioSystem.getLine(info);
//                clip.open(audioStream);
//            } catch (Exception e) {
//                throw new PuffinBasicRuntimeError(
//                        IO_ERROR,
//                        "Failed to get/open line from audio: " + file + ", error: " + e.getMessage()
//                );
//            }
//            var id = counter.incrementAndGet();
//            state.put(id, new ClipState(audioStream, clip));
//            return id;
//        });
//        try {
//            return future.get();
//        } catch (Exception e) {
//            throw new PuffinBasicRuntimeError(
//                    IO_ERROR,
//                    "Failed to get id from loaded audio: " + file + ", error: " + e.getMessage()
//            );
//        }
        return 0;
    }


//    private ClipState get(int id) {
//        var s = state.get(id);
//        if (s == null) {
//            throw new PuffinBasicRuntimeError(
//                    ILLEGAL_FUNCTION_PARAM,
//                    "Failed to get sound clip for id: " + id
//            );
//        }
//        return s;
//    }

    public void play(int id) {
//        executor.submit(() -> {
//            var clip = get(id).clip;
//            if (clip.isRunning()) {
//                clip.stop();
//            }
//            clip.setFramePosition(0);
//            clip.start();
//        });
    }

    public void stop(int id) {
//        executor.submit(() -> {
//            var clip = get(id).clip;
//            if (clip.isRunning()) {
//                clip.stop();
//            }
//        });
    }

    public void loop(int id) {
//        executor.submit(() -> {
//            var clip = get(id).clip;
//            if (clip.isRunning()) {
//                clip.stop();
//            }
//            clip.setFramePosition(0);
//            clip.loop(Clip.LOOP_CONTINUOUSLY);
//        });
    }

    @Override
    public void close() {
//        state.values().forEach(s -> s.clip.close());
//        executor.shutdownNow();
    }
}
