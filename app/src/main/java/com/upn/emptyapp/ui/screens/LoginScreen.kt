package com.upn.emptyapp.ui.screens

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.datastore.preferences.core.edit
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.upn.emptyapp.dataStore
import com.upn.emptyapp.ui.components.*
import com.upn.emptyapp.ui.theme.SanctuaryTheme
import com.upn.emptyapp.viewModels.PreferencesViewModel

@Composable
fun LoginScreen(
    onLoginClick: (String, String) -> Unit = { _, _ -> },
    onRegisterClick: () -> Unit = {},
    viewModel: PreferencesViewModel = viewModel()
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    val scrollState = rememberScrollState()

//    val auth = FirebaseAuth.getInstance()

    val context: Context = LocalContext.current

    val auth = Firebase.auth

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(scrollState)
                .padding(horizontal = SanctuaryTheme.Spacing.lg),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(SanctuaryTheme.Spacing.xxl))

            // Logo / Title Section
            AppDisplay(
                text = "PetSanctuary",
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(SanctuaryTheme.Spacing.md))

            AppBody(
                text = "Encuentra a tu compañero perfecto",
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(SanctuaryTheme.Spacing.xxl))

            // Login Form
            AppCard(
                modifier = Modifier.fillMaxWidth()
            ) {
                AppTitle(
                    text = "Iniciar Sesión",
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(SanctuaryTheme.Spacing.lg))

                // Email Input
                AppInput(
                    value = email,
                    onValueChange = { 
                        email = it
                        errorMessage = null
                    },
                    label = "Correo electrónico",
                    placeholder = "tu@email.com"
                )

                Spacer(modifier = Modifier.height(SanctuaryTheme.Spacing.md))

                // Password Input
                AppInput(
                    value = password,
                    onValueChange = { 
                        password = it
                        errorMessage = null
                    },
                    label = "Contraseña",
                    placeholder = "••••••••"
                )

                // Error Message
                if (errorMessage != null) {
                    Spacer(modifier = Modifier.height(SanctuaryTheme.Spacing.md))
                    Text(
                        text = errorMessage!!,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.error,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                Spacer(modifier = Modifier.height(SanctuaryTheme.Spacing.xl))

                // Login Button
                AppButton(
                    text = "Ingresar",
                    onClick = {
                        when {
                            email.isBlank() || password.isBlank() -> {
                                errorMessage = "Por favor complete todos los campos"
                            }
                            else -> {
                                // voy a llamar a firebase
                                auth.signInWithEmailAndPassword(email, password)
                                    .addOnSuccessListener { result ->
                                        viewModel.guardarSesion(context)
//                                        errorMessage = "Inicio de sesión exitoso"
                                        onLoginClick(email, password)



                                    }.addOnFailureListener { result ->
                                        errorMessage = "Usuario y/o contraseña incorrecta"
                                    }
                            }
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.height(SanctuaryTheme.Spacing.xl))

            // Register Link
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = "¿No tienes cuenta?",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "Regístrate",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    ),
                    modifier = Modifier.clickable { onRegisterClick() }
                )
            }

            Spacer(modifier = Modifier.height(SanctuaryTheme.Spacing.xxl))
        }
    }
}
