package ru.konsli.feature_auth.domain.validator

object EmailValidator {
    // Только латиница, цифры и допустимые символы
    private val emailRegex =
        Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")

    fun validate(email: String): Boolean {
        return email.matches(emailRegex)
    }
}