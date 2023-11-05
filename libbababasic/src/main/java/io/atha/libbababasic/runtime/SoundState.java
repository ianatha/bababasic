package io.atha.libbababasic.runtime;

public interface SoundState extends AutoCloseable {
    int load(String file);

    void play(int id);

    void stop(int id);

    void loop(int id);
}

