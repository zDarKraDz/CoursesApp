package ru.konsli.feature_auth.domain.usecase

class LoginUseCase {
    operator fun invoke(email: String, password: String): Boolean {
        val regex = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")

        return regex.matches(email) && password.length >= 6
    }
}