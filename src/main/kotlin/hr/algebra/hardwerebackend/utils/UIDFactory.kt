package hr.algebra.hardwerebackend.utils

class UIDFactory {

    companion object {
        fun generateUID(): String {
            val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
            val length = 10
            return (1..length)
                .map { chars.random() }
                .joinToString("")
        }
    }
}