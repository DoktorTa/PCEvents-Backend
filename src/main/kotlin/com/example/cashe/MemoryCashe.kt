package com.example.cashe

import com.example.features.register.RegisterReseive

// while we haven't Data Base

data class TokenCashe(
    val login: String,
    val token: String
)

object MemoryCashe {
    val userList: MutableList<RegisterReseive> = mutableListOf()
    val tokensUsers: MutableList<TokenCashe> = mutableListOf()
}