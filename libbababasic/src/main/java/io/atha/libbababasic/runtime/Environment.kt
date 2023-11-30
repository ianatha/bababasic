package io.atha.libbababasic.runtime

interface Environment {
    operator fun get(key: String): String
    operator fun set(key: String, value: String)
    fun getStorageFolder(): String
}

