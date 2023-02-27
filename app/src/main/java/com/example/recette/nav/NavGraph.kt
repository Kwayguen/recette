package com.example.recette.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.recette.LoginScreen
import com.example.recette.RegisterScreen
import com.example.recette.SearchScreen
import com.google.firebase.auth.FirebaseAuth

@Composable
fun SetupNavGraph(
    auth: FirebaseAuth,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(
            route = Screen.Login.route
        ){
            LoginScreen(navController = navController, auth = auth)
            //SetupNavGraph(navController = navController)
        }
        composable(
            route = Screen.Register.route
        ){
            RegisterScreen(navController = navController)
            //SetupNavGraph(navController = navController)
        }
        composable(
            route = Screen.Search.route
        ){
            SearchScreen(navController = navController)
        }
    }
}