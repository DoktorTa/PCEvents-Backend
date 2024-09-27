package com.example.auth.jwt

import java.security.SecureRandom
import java.util.Base64

fun generateSecretKey(): String {
    val random = SecureRandom()
    val keyBytes = ByteArray(32)
    random.nextBytes(keyBytes)
    return Base64.getEncoder().encodeToString(keyBytes)
}

fun setEnvironmentVariable() {
    val secretKey = generateSecretKey()
    System.setProperty("JWT_SECRET", secretKey)
}