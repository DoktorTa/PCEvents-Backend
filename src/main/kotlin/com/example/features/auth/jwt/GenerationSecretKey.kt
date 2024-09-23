package com.example.features.auth.jwt

import java.security.SecureRandom
import java.util.Base64

fun generateSecretKey(): String {
    val random = SecureRandom()
    val keyBytes = ByteArray(32)
    random.nextBytes(keyBytes)
    return Base64.getEncoder().encodeToString(keyBytes)
}