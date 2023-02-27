package com.example.recette.nav

sealed class Screen(val route: String)
{
    object Login: Screen(route = "login_screen")
    object Register: Screen(route = "register_screen")
    object Search: Screen(route= "search_screen")
}