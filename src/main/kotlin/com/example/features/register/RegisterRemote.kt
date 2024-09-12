package com.example.features.register

import kotlinx.serialization.Serializable

@Serializable
data class RegisterReseive(
    val login: String,
    val email: String,
    val password: String
)

@Serializable
data class RegisterResponse(
    val token: String
)
