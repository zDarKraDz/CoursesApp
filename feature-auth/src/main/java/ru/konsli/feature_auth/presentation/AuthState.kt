package ru.konsli.feature_auth.presentation

data class AuthState(
    val email: String = "",
    val password: String = "",
    val isAuthorized: Boolean = false,
    val isEmailError: Boolean = false,
    val isPasswordError: Boolean = false

)
