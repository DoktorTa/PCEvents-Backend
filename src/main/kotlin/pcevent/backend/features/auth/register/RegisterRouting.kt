package com.example.features.auth.register

import com.example.cashe.MemoryCashe
import com.example.cashe.TokenCashe
import com.example.utils.isValidEmail
import com.example.utils.isValidPassword
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.util.UUID

fun Application.configureRegisterRouting() {
    routing {
        post ("/register") {
            val receive = call.receive<RegisterReseive>()

            if (MemoryCashe.userList.map{it.login}.contains(receive.login) or
                MemoryCashe.userList.map{it.email}.contains(receive.email)) {
                call.respond("We have this user")
                return@post
            }

            if (!receive.email.isValidEmail()){
                call.respond("Email isn't valid")
                return@post
            }

            if (!receive.password.isValidPassword()) {
                call.respond("Bad password")
                return@post
            }

            val token = UUID.randomUUID().toString()
            MemoryCashe.userList.add(receive)
            MemoryCashe.tokensUsers.add(TokenCashe(login = receive.login, token))
            call.respond(RegisterResponse(token = token))
            return@post
        }
    }
}