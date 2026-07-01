package ru.konsli.courses.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.konsli.core.navigation.BottomDestination
import ru.konsli.feature_favorites.presentation.FavoritesScreen
import ru.konsli.feature_home.presentation.HomeScreen
import ru.konsli.feature_profile.presentation.ProfileScreen

@Composable
fun BottomNavGraph(
    navController: NavHostController,
    paddingValues: PaddingValues
) {

    NavHost(
        navController = navController,
        startDestination = BottomDestination.Home.route
    ) {

        composable(BottomDestination.Home.route) {

            HomeScreen(
                modifier = Modifier.padding(paddingValues)
            )
        }

        composable(BottomDestination.Favorites.route) {

            FavoritesScreen(
                modifier = Modifier.padding(paddingValues)
            )
        }

        composable(BottomDestination.Profile.route) {

            ProfileScreen(
                modifier = Modifier.padding(paddingValues)
            )
        }
    }
}