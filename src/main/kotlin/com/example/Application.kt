package com.example

import com.example.auth.jwt.setEnvironmentVariable
import com.example.auth.login.configureLoginRouting
import com.example.auth.register.configureRegisterRouting
import com.example.plugins.*
import io.ktor.server.application.*

fun main(args: Array<String>) {
    setEnvironmentVariable()
    io.ktor.server.cio.EngineMain.main(args)
}

fun Application.module() {
    configureSerialization()
    configureSecurity()
    configureRouting()
    configureRegisterRouting()
    configureLoginRouting()
}
