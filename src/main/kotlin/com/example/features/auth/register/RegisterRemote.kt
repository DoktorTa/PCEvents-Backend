package com.example.features.auth.register

import kotlinx.serialization.Serializable

@Serializable
data class RegisterRequest(
    val login: String,
    val email: String,
    val password: String
)

@Serializable
data class RegisterResponse(
    val status: String?,
    val accessToken: String?,
    val refreshToken: String?
)
