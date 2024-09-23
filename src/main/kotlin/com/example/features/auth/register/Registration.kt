package com.example.features.auth.register


import com.example.features.auth.isValidEmail
import com.example.features.auth.isValidPassword
import com.example.features.auth.jwt.JwtConfig

class Registration {
    private val regRepo: RegistrationRepository = RegistrationRepository()

    fun register(registerRequest: RegisterRequest) : RegisterResponse {

        if (regRepo.getEmail(registerRequest.email) && registerRequest.email.isValidEmail()) {
            return RegisterResponse(status = "Email is exists", accessToken = null, refreshToken = null)
        }

        if (regRepo.getLogin(registerRequest.login)) {
            return RegisterResponse(status = "Login is exists", accessToken = null, refreshToken = null)
        }

        if (registerRequest.password.isValidPassword()) {
            return RegisterResponse(status = "Password incorrect", accessToken = null, refreshToken = null)
        }

        // TODO: Код который ложит нового юзера в бд.

        val accessToken: String = JwtConfig.generateAccessToken(registerRequest.login)
        val refreshToken: String = JwtConfig.generateRefreshToken(registerRequest.login)
        return RegisterResponse(status = "Correct", accessToken = accessToken, refreshToken = refreshToken)
    }
}