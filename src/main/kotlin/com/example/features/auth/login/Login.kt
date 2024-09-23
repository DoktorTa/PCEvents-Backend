package com.example.features.auth.login


import com.example.features.auth.jwt.JwtConfig
import com.example.features.auth.register.RegisterResponse

class Login {
    private val logRepo = LoginRepository()
    fun logIn(loginRequest: LoginRequest): LoginResponse{
        if (!logRepo.checkLogin(loginRequest.login)){
            return LoginResponse(status = "Incorrect email", accessToken = null, refreshToken = null)
        }
        if (!logRepo.checkPassword(loginRequest.password)){
            return LoginResponse(status = "Incorrect password", accessToken = null, refreshToken = null)
        }
        val accessToken: String = JwtConfig.generateAccessToken()// TODO: Акцес токен
        val refreshToken: String = JwtConfig.generateRefreshToken()// TODO: Рефреш токен
        return RegisterResponse(status = "Correct", accessToken = accessToken, refreshToken = refreshToken)
    }
}