package com.example.recette

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.recette.ui.main.MainActivity
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth

/*
var email = "";
var password = "";
*/

@Composable
fun LoginScreen(
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
            Title("ReCeTTe")
            LoginText(navController = navController)
            /*EmailField()*/
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
            /*LoginButton(
                navController = navController,
                auth = auth,
                email = email,
                password = password
            )*/
            Button(
                onClick = {
                    //navController.navigate(route = Screen.Search.route)
                    auth.signInWithEmailAndPassword(emailField.value, passwordField.value)
                        .addOnCompleteListener() { task ->
                            if (task.isSuccessful)
                            {
                                Log.d(TAG, "signInWithEmail:success")
                                val user = auth.currentUser
                                navController.navigate(route = Screen.Search.route)
                            } else {
                                val activity = MainActivity()
                                activity.toast_short("Email and Password combination failed")
                            }
                        }
                },
                modifier = Modifier.padding(8.dp),
            ) {
                Text("Login ")
                Icon(
                    Icons.Filled.Done,
                    contentDescription = "Login",
                    modifier = Modifier.size(ButtonDefaults.IconSize),
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            }
        }
    }
}

@Composable
fun LoginButton(
    navController: NavController,
    auth: FirebaseAuth,
    email: String,
    password: String
)
{
    Button(
        onClick = {
            navController.navigate(route = Screen.Search.route)
            //auth.signInWithEmailAndPassword(email, password);
        },
        modifier = Modifier.padding(8.dp),
    ) {
        Text("Login ")
        Icon(
            Icons.Filled.Done,
            contentDescription = "Login",
            modifier = Modifier.size(ButtonDefaults.IconSize),
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
    }
}

@Composable
fun Title(title: String)
{
    Text(
        modifier = Modifier.padding(8.dp),
        text = title,
        color = MaterialTheme.colors.primary,
        fontSize = MaterialTheme.typography.h3.fontSize,
        fontWeight = FontWeight.Bold
    );
}

@Composable
fun EmailField() {
    var emailField = remember { mutableStateOf("") }
    OutlinedTextField(
        modifier = Modifier.padding(8.dp),
        value = emailField.value,
        onValueChange = {
            emailField.value = it
            //email = it
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
}

@Composable
fun PasswordField() {
    var password = remember { mutableStateOf("") }
    OutlinedTextField(
        modifier = Modifier.padding(8.dp),
        value = password.value,
        onValueChange = {
            password.value = it
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
}

@Composable
fun LoginText(navController: NavController)
{
    Text(
        modifier = Modifier.clickable {
            navController.navigate(route = Screen.Register.route)
        },
        text = "LOGIN",
        color = MaterialTheme.colors.primary,
        fontSize = MaterialTheme.typography.h3.fontSize,
        fontWeight = FontWeight.Bold
    );
}