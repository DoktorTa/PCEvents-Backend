package pcevent.backend.features.auth.register

import pcevent.backend.cashe.MemoryCashe
import pcevent.backend.cashe.TokenCashe
import io.ktor.server.application.*
import io.ktor.server.response.*
import pcevent.backend.features.auth.isValidEmail
import pcevent.backend.features.auth.isValidPassword
import java.util.*

class Registration {
    private val regRepo: RegistrationRepository = RegistrationRepository()

    fun register(registerRequest: RegisterRequest) : RegisterResponse {

        if (regRepo.getEmail(registerRequest.email) && registerRequest.email.isValidEmail()) {
            return RegisterResponse(status = "Email is exists", accessToken = null, refreshToken = null)
        }

        if (regRepo.getLogin(registerRequest.login)) {
            return RegisterResponse(status = "Login is exists", accessToken = null, refreshToken = null)
        }

        if (registerRequest.password.isValidPassword()) {
            return RegisterResponse(status = "Password incorrect", accessToken = null, refreshToken = null)
        }

        // TODO: Код который ложит нового юзера в бд.

        // val accessToken: String = // TODO: Акцес токен
        // val refreshToken: String = // TODO: Рефреш токен
        // return RegisterResponse(status = "Correct", accessToken = accessToken, refreshToken = refreshToken)
    }
}