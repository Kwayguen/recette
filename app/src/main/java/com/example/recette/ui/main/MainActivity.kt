package com.example.recette.ui.main

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.recette.SetupNavGraph
import com.example.recette.ui.theme.RecetteTheme
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class MainActivity : ComponentActivity() {

    private lateinit var auth: FirebaseAuth
    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        setContent {
            RecetteTheme {
                navController = rememberNavController()
                SetupNavGraph(navController = navController, auth = auth)
            }
        }
    }

    companion object {

        lateinit  var appContext: Context

    }
    fun toastShort(msg: String) {
        val toast = Toast.makeText(this, msg, Toast.LENGTH_LONG)
        toast.show()
    }

}
