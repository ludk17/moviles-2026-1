package com.upn.emptyapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import com.upn.emptyapp.models.Estudiante
import com.upn.emptyapp.ui.theme.SanctuaryTheme

@Composable
fun FireBaseCreateScreen(navController: NavController) {
    val firestore = Firebase.firestore // esta linea es la instancia de base de datos;

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
    ) { paddingValues ->

        var nombre by remember { mutableStateOf("") }
        var apellido by remember { mutableStateOf("") }
        var nombreError  by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(SanctuaryTheme.Spacing.lg)
        ) {
            Text("Formulario")


            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre de estudiante") }
            )

            Text(text = nombreError)

            OutlinedTextField(
                value = apellido,
                onValueChange = { apellido = it },
                label = { Text("Apellido de estudiante") }
            )


            Button(onClick = {
                nombreError = ""
                if (nombre.isEmpty()) {
                    nombreError = "Nombre es obligatorio"
                    return@Button
                }

                val estudiante = Estudiante(
                    nombre = nombre,
                    apellido = apellido
                )

                val ref = firestore.collection("estudiantes").document();
                estudiante.id = ref.id
                ref.set(estudiante)
                    .addOnSuccessListener { result ->
                        navController.navigate("home")
                    }


                // actualiza
                firestore.collection("estudiantes")
                    .document("F52bMbEHxqP0HJWB37Zx")
                    .set(estudiante)
                    .addOnSuccessListener { result ->}


            }) {
                Text("Enviar Formulario")
            }

        }
    }
}