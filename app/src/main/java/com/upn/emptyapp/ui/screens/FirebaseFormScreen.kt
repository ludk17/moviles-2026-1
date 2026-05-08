package com.upn.emptyapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.upn.emptyapp.models.Estudiante
import com.upn.emptyapp.ui.shared.theme.AppColors

@Composable
fun FirebaseFormScreen(navController: NavController) {
    val firestore = Firebase.firestore

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = AppColors.Surface,
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {

            var nombre by remember { mutableStateOf("") }
            var apellido by remember { mutableStateOf("") }

            Text("Formulario de Firebase")

            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre") }
            )

            OutlinedTextField(
                value = apellido,
                onValueChange = { apellido = it },
                label = { Text("Apellido") }
            )

            Button(onClick = {

                val estudiante = Estudiante(
                    nombre =nombre,
                    appellido = apellido
                )

                // aca va el codigo para crear estudiante
                firestore.collection("estudiantes")
                    .add(estudiante)
                    .addOnSuccessListener { result ->
                        navController.navigate("home")
                    }

            }) {
                Text("Crear")
            }
        }
    }
}