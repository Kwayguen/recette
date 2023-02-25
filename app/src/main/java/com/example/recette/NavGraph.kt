package com.example.recette

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

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