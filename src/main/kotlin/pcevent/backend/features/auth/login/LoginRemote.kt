package pcevent.backend.features.auth.login

import kotlinx.serialization.Serializable

@Serializable
data class LoginReceive(
    val login: String,
    val password: String,
)

@Serializable
data class RefreshTokenRequests (
    val refreshToken: String?
)


@Serializable
data class RegisterResponse(
    val accessToken: String?,
    val refreshToken: String?,
)
