package com.example.auth.jwt

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import java.util.*

object JwtConfig {

    val secret: String = System.getenv("JWT_SECRET") ?: throw IllegalArgumentException("JWT_SECRET is not defined in environment variables")
    val algorithm = Algorithm.HMAC256(secret)

    private const val DAY: Int = 24 * 60 * 60 * 1000
    private const val WEEK: Int = 7 * 24 * 60 * 60 * 1000 // тут int все норм

    fun generateAccessToken(userId: String): String {
        return JWT.create()
            .withIssuer("pc-event")  // ENV
            .withClaim("userId", userId)
            .withIssuedAt(Date())
            .withExpiresAt(Date(System.currentTimeMillis() + DAY))
            .sign(algorithm)
    }

    fun generateRefreshToken(userId: String): String {
        return JWT.create()
            .withIssuer("pc-event")
            .withClaim("userId", userId)
            .withIssuedAt(Date())
            .withExpiresAt(Date(System.currentTimeMillis() + WEEK))
            .sign(algorithm)
    }
}