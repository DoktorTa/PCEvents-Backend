package com.example.auth.login

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(
    val login: String,
    val password: String,
)

@Serializable
data class RefreshTokenRequests (
    val refreshToken: String?
)


@Serializable
data class LoginResponse(
    val status: String?,
    val accessToken: String?,
    val refreshToken: String?,
)
