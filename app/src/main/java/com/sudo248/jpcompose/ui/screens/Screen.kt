package com.sudo248.jpcompose.ui.screens


/**
 * **Created by**
 *
 * @author *Sudo248*
 * @since 01:02 - 24/11/2022
 */
sealed class Screen(val route: String) {
    object HomeScreen : Screen("home_screen")
    object DetailScreen : Screen("detail_screen")
}
