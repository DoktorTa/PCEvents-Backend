package com.example.features.auth.jwt

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import java.util.*

object JwtConfig {

    val secret = generateSecretKey()
    val algorithm = Algorithm.HMAC256(secret)


    fun generateAccessToken(userId: String): String {
        return JWT.create()
            .withIssuer("your-issuer")
            .withClaim("userId", userId)
            .withExpiresAt(Date(System.currentTimeMillis() + 10 * 60 * 1000))
            .sign(algorithm)
    }

    fun generateRefreshToken(userId: String): String {
        return JWT.create()
            .withIssuer("your-issuer")
            .withClaim("userId", userId)
            .withExpiresAt(Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000))
            .sign(algorithm)
    }
}