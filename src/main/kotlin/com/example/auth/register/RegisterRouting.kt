package com.example.auth.register

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRegisterRouting() {
    routing {
        post ("/register") {
            val registerRequest: RegisterRequest = call.receive<RegisterRequest>()
            println(1)
            val response: RegisterResponse = Registration().register(registerRequest)
            call.respond(response)
            return@post
        }
    }
}