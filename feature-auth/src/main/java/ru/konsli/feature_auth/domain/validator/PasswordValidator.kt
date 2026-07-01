package ru.konsli.feature_auth.domain.validator

object PasswordValidator {
    fun validate(password: String): Boolean {
        return password.isNotBlank() // Проверка на пустоту
    }
}