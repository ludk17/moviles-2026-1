package com.upn.emptyapp.ui.screens

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import android.util.Patterns
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import com.upn.emptyapp.viewmodels.UserViewModel

@Composable
fun LoginScreen(onClick: () -> Unit, onSuccess: () -> Unit, viewModel: UserViewModel = viewModel()) {
    var password by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf<String?>(null) }
    var passwordError by remember { mutableStateOf<String?>(null) }
    val context = LocalContext.current

    LaunchedEffect(viewModel.isAuthenticated) {
        if (viewModel.isAuthenticated ) {
            onSuccess()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Iniciar Sesión",
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(modifier = Modifier.height(32.dp))

        if (viewModel.authError != "") {
            Text(
                text = viewModel.authError,
                color = MaterialTheme.colorScheme.error,
            )
        }

        OutlinedTextField(
            value = email,
            onValueChange = { v ->
                email = v
                emailError = null
            },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            isError = emailError != null,
            supportingText = {
                if (emailError != null) {
                    Text(emailError!!)
                }
            },
            trailingIcon = { if (emailError != null) Icon(Icons.Filled.Warning, "Error") }
        )


        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
                passwordError = null
            },
            label = { Text("Contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            isError = passwordError != null,
            supportingText = { passwordError?.let { Text(it) } },
            trailingIcon = { if (passwordError != null) Icon(Icons.Filled.Warning, "Error") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                emailError = null
                passwordError = null

                if (email.isEmpty()) {
                    emailError = "El email es requerido."
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    emailError = "Formato de email inválido."
                } /*else if(!email.endsWith("gmail.com")) {
                    emailError = "Solo se permite correos gmail.com"
                }*/

                if (password.isEmpty()) {
                    passwordError = "La contraseña es requerida."
                }

                if (emailError == null && passwordError == null) {
                    viewModel.login(email, password);

                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "¿No tienes cuenta? Regístrate aquí",
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.clickable {
                onClick()
            }
        )
    }
}
