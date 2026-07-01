package ru.konsli.core.navigation

import androidx.annotation.DrawableRes
import ru.konsli.core.R

sealed class BottomNavItem(
    val route: String,
    val title: String,
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unselectedIcon: Int
) {

    data object Home : BottomNavItem(
        BottomDestination.Home.route,
        "Главная",
        R.drawable.home_green,
        R.drawable.home_white
    )

    data object Favorites : BottomNavItem(
        BottomDestination.Favorites.route,
        "Избранное",
        R.drawable.bookmark_green,
        R.drawable.bookmark_white
    )

    data object Profile : BottomNavItem(
        BottomDestination.Profile.route,
        "Аккаунт",
        R.drawable.profile_green,
        R.drawable.profile_white
    )
}