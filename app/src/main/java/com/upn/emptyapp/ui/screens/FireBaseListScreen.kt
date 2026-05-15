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
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import com.upn.emptyapp.models.Estudiante
import com.upn.emptyapp.ui.theme.SanctuaryTheme

@Composable
fun FireBaseListScreen(navController: NavController) {
    val firestore = Firebase.firestore // esta linea es la instancia de base de datos;
    var auth = Firebase.auth

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate("registrar_estudiante")
            }) {
                Icon(Icons.Filled.Add, "Floating action button.")
            }
        }
    ) { paddingValues ->

        /** los mutable me permite que cuando cambia de valor la pantalla se redibuja */
        var isLoading by remember { mutableStateOf(false) }
        var estudiantes by remember { mutableStateOf(emptyList<Estudiante>()) }

        // LaunchedEffect me permite hacer llamadas asincronas
        LaunchedEffect(Unit) {
            // llamar funciones asincronas;
            isLoading = true
            firestore
                .collection("estudiantes") // apunta a la collection estudaintes
                .get() // listar todos
                .addOnSuccessListener { snap -> // se ejecuta cuando tenemos los datos porque es asincrono

                    /** transforma documetos en lista de estudiante **/
                    estudiantes = snap.documents.mapNotNull { document ->
                        document.toObject(Estudiante::class.java)
                    }
                    isLoading = false
                }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(SanctuaryTheme.Spacing.lg)
        ) {
            if (isLoading) {
                CircularProgressIndicator()
            } else {
                LazyColumn() {
                    items(estudiantes) { item ->
                        Text(item.nombre)
                    }
                }
            }

            Button(onClick = {
                auth.signOut()
                navController.navigate("login")
            }) {
                Text("Cerrar Sesion")
            }
        }
    }
}