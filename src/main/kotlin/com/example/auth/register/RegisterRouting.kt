package com.example.auth.register

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRegisterRouting() {
    routing {
        post ("/register") {
            try {
                val registerRequest: RegisterRequest = call.receive<RegisterRequest>()
                val response: RegisterResponse = Registration().register(registerRequest)
                call.respond(response)
                return@post
            } catch (e: BadRequestException){
                call.respond("Incomplete request")
                return@post
            } catch (e: Exception) {
                call.respond(HttpStatusCode.InternalServerError, "Внутренняя ошибка сервера: ${e.message}")
            }
        }
    }
}