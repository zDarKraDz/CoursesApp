package ru.konsli.core.navigation

sealed class BottomDestination(val route: String) {

    data object Home : BottomDestination("home")

    data object Favorites : BottomDestination("favorites")

    data object Profile : BottomDestination("profile")
}