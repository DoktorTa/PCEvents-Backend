package com.example.auth

fun String.isValidEmail(): Boolean{
    val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
    return this.matches(emailRegex.toRegex())
}

fun String.isValidPassword(): Boolean{

    if (this.length < 8) return false

    val hasUppercase = this.any { it.isUpperCase() }
    val hasLowercase = this.any { it.isLowerCase() }
    val hasDigit = this.any { it.isDigit() }

    return hasUppercase && hasLowercase && hasDigit
}