package com.example.recette.ui.register

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.recette.Screen
import com.google.firebase.auth.FirebaseAuth

@Composable
fun RegisterScreen(
    auth: FirebaseAuth,
    navController: NavController
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
        Text(
            modifier = Modifier.clickable {
                navController.navigate(Screen.Login.route){
                    popUpTo(Screen.Login.route){
                        inclusive = true
                    }
                }
            },
            text = "REGISTER",
            color = MaterialTheme.colors.primary,
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold
        )
        var emailField = remember { mutableStateOf("") }
        OutlinedTextField(
            modifier = Modifier.padding(8.dp),
            value = emailField.value,
            onValueChange = {
                emailField.value = it
            },
            label = {
                Text(text = "Email")
            },
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = "Email Icon"
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,

                )
        )
        //PasswordField()
        var passwordField = remember { mutableStateOf("") }
        OutlinedTextField(
            modifier = Modifier.padding(8.dp),
            value = passwordField.value,
            onValueChange = {
                passwordField.value = it
            },
            label = {
                Text(text = "Password")
            },
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Lock,
                    contentDescription = "Password Icon"
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            trailingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = "Visibility Icon")
                }
            },
        )
        var passwordConfirmationField = remember { mutableStateOf("") }
        OutlinedTextField(
            modifier = Modifier.padding(8.dp),
            value = passwordConfirmationField.value,
            onValueChange = {
                passwordConfirmationField.value = it
            },
            label = {
                Text(text = "Password confirmation")
            },
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Lock,
                    contentDescription = "Password Icon"
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            trailingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = "Visibility Icon")
                }
            },
        )
        Button(
            onClick = {
                if((emailField.value != "" && passwordField.value != "" && passwordConfirmationField.value != "") && passwordField.value != passwordConfirmationField.value)
                {
                    auth.createUserWithEmailAndPassword(emailField.value, passwordField.value)
                        .addOnCompleteListener() { task ->
                            if (task.isSuccessful) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "createUserWithEmail:success")
                                //val user = auth.currentUser
                                navController.navigate(route = Screen.Search.route)
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "createUserWithEmail:failure", task.exception)
                            }
                        }
                } else {
                    Log.d(ContentValues.TAG, "emptyFields")
                }
            },
            modifier = Modifier.padding(8.dp),
        ) {
            Text("Register ")
            Icon(
                Icons.Filled.Done,
                contentDescription = "Register",
                modifier = Modifier.size(ButtonDefaults.IconSize),
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        }
            Text(
                modifier = Modifier.clickable {
                    navController.navigate(Screen.Login.route){
                        popUpTo(Screen.Login.route){
                            inclusive = true
                        }
                    }
                },
                text = "Click here to login",
                color = MaterialTheme.colors.primary,
                fontSize = MaterialTheme.typography.h5.fontSize,
                fontWeight = FontWeight.Bold
            )
    }
}}

