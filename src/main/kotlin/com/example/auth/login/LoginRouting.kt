package com.example.auth.login


import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureLoginRouting() {
    routing {
        post("/login") {
            val loginRequest: LoginRequest = call.receive<LoginRequest>()
            val response: LoginResponse = Login().logIn(loginRequest)
            call.respond(response)
            return@post
        }
    }
}


