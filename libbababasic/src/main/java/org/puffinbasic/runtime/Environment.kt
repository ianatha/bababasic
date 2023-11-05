package org.puffinbasic.runtime

interface Environment {
    operator fun get(key: String): String
    operator fun set(key: String, value: String)
}

class SystemEnv : Environment {
    private val overrides: MutableMap<String, String>

    init {
        overrides = HashMap()
    }

    override fun get(key: String): String {
        val result = overrides[key]
        return result ?: System.getenv(key) ?: ""
    }

    override fun set(key: String, value: String) {
        overrides[key] = value
    }
}