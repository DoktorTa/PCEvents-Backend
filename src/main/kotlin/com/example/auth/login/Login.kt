package com.example.auth.login


import com.example.auth.jwt.JwtConfig
import com.example.auth.register.RegisterResponse

class Login {
    private val logRepo = LoginRepository()
    fun logIn(loginRequest: LoginRequest): LoginResponse {
        if (!logRepo.checkLogin(loginRequest.login)){
            return LoginResponse(status = "Incorrect email", accessToken = null, refreshToken = null)
        }
        if (!logRepo.checkPassword(loginRequest.password)){
            return LoginResponse(status = "Incorrect password", accessToken = null, refreshToken = null)
        }
        val accessToken: String = JwtConfig.generateAccessToken(loginRequest.login)
        val refreshToken: String = JwtConfig.generateRefreshToken(loginRequest.login)
        return LoginResponse(status = "Correct", accessToken = accessToken, refreshToken = refreshToken)
    }
}