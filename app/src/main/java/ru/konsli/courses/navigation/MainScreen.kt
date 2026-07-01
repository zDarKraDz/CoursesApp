package ru.konsli.courses.navigation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import ru.konsli.core.ui.components.BottomNavigationBar

@Composable
fun MainScreen() {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                currentRoute =
                    navController.currentBackStackEntry
                        ?.destination
                        ?.route
                        ?: "",

                onItemClick = { route ->

                    navController.navigate(route) {

                        launchSingleTop = true

                        restoreState = true

                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                    }
                }
            )
        }

    ) { padding ->
        BottomNavGraph(
            navController = navController,
            paddingValues = padding
        )
    }
}