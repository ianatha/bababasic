package io.atha.bababasic.terminal

import io.atha.libbababasic.runtime.SoundState

class AndroidSoundState : SoundState {
    override fun close() {
    }

    override fun load(file: String?): Int {
        return 0
    }

    override fun play(id: Int) {
    }

    override fun stop(id: Int) {
    }

    override fun loop(id: Int) {
    }
}
