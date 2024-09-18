package pcevent.backend.features.auth.register

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRegisterRouting() {
    routing {
        post ("/register") {
            val registerRequest: RegisterRequest = call.receive<RegisterRequest>()
            val response: RegisterResponse = Registration().register(registerRequest)
            call.respond(response)
            return@post
        }
    }
}