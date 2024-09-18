package pcevent.backend

import com.example.features.auth.login.configureLoginRouting
import com.example.features.auth.register.configureRegisterRouting
import com.example.plugins.*
import io.ktor.server.application.*
import io.ktor.server.cio.*
import io.ktor.server.engine.*

fun main() {
    embeddedServer(CIO, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureSockets()
    configureSecurity()
    configureSerialization()
    configureRouting()
    configureLoginRouting()
    configureRegisterRouting()
}
