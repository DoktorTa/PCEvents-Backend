package com.example.utils

fun String.isValidPassword(): Boolean{

    if (this.length < 8) return false

    val hasUppercase = this.any { it.isUpperCase() }
    val hasLowercase = this.any { it.isLowerCase() }
    val hasDigit = this.any { it.isDigit() }

    return hasUppercase && hasLowercase && hasDigit
}