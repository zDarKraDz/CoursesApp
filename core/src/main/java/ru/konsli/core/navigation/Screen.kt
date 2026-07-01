package ru.konsli.core.navigation

/**
    Здесь два экрана верхнего уровня.

    Авторизация
    Основная часть приложения
 */
sealed class Screen(val route: String) {

    data object Auth : Screen("auth")

    data object Main : Screen("main")
}