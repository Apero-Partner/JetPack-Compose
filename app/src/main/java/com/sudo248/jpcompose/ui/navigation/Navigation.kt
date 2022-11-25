package com.sudo248.jpcompose.ui.navigation

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.sudo248.jpcompose.User
import com.sudo248.jpcompose.ui.screens.DetailScreen
import com.sudo248.jpcompose.ui.screens.HomeScreen
import com.sudo248.jpcompose.ui.screens.Screen


/**
 * **Created by**
 *
 * @author *Sudo248*
 * @since 00:57 - 24/11/2022
 */

@Composable
fun Navigation() {
    val navController = rememberNavController()
    Scaffold {
        NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
            composable(
                Screen.HomeScreen.route,
            ) {
                HomeScreen(navController = navController)
            }

            composable(
                Screen.DetailScreen.route + "/{user}",
                arguments = listOf(
                    navArgument("user") {
                        type = NavType.StringType
                    }
                )
            ) { entry ->
                val user = entry.arguments?.getString("user")?.let { Gson().fromJson(it, User::class.java) } ?: User(1, "", "")
                DetailScreen(navController = navController, user = user)
            }
        }
    }
}