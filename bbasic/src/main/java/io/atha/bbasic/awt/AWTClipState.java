package io.atha.bbasic.awt;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;

final class AWTClipState implements AutoCloseable {
    final AudioInputStream stream;
    final Clip clip;

    AWTClipState(AudioInputStream stream, Clip clip) {
        this.stream = stream;
        this.clip = clip;
    }

    @Override
    public void close() throws Exception {
        clip.close();
        stream.close();
    }
}
