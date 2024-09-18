package com.example.features.auth.login

import com.example.cashe.MemoryCashe
import com.example.cashe.TokenCashe
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.util.UUID

fun Application.configureLoginRouting() {
    routing {
        post("/login") {
            val receive = call.receive<LoginReceive>()
            if (MemoryCashe.userList.map { it.login }.contains(receive.login)) {
                if (MemoryCashe.userList.map { it.password }.contains(receive.password)) {
                    val token = UUID.randomUUID().toString()
                    MemoryCashe.tokensUsers.add(TokenCashe(login = receive.login, token))
                    call.respond(HttpStatusCode.OK, LoginResponse(token))
                    return@post
                } else {
                    call.respond(HttpStatusCode.Conflict, "Incorrect password")
                    return@post
                }

            } else {
                call.respond(HttpStatusCode.BadRequest, "We haven't this user")
                return@post
            }
        }
    }
}


