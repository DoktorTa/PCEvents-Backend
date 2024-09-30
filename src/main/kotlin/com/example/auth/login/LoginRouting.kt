package com.example.auth.login


import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Application.configureLoginRouting() {
    routing {
        post("/login") {
            try {
                val loginRequest: LoginRequest = call.receive<LoginRequest>()
                val response: LoginResponse = Login().logIn(loginRequest)
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


