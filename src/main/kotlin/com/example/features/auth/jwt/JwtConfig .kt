package com.example.features.auth.jwt

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import java.util.*

object JwtConfig {

    val secret = generateSecretKey()  // ENV for secret
    val algorithm = Algorithm.HMAC256(secret)

    private const val DAY: Int = 24 * 60 * 60 * 1000
    private const val WEEK: Int = 7 * 24 * 60 * 60 * 1000  // TODO: Точно ли не лонг?

    fun generateAccessToken(userId: String): String {
        return JWT.create()
            .withIssuer("your-issuer")  // ENV
            .withClaim("userId", userId)
            .withExpiresAt(Date(System.currentTimeMillis() + DAY))
            .sign(algorithm)
    }

    fun generateRefreshToken(userId: String): String {
        return JWT.create()
            .withIssuer("your-issuer")
            .withClaim("userId", userId)
            .withExpiresAt(Date(System.currentTimeMillis() + WEEK))
            .sign(algorithm)
    }
}