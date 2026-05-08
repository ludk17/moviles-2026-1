package com.upn.emptyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.upn.emptyapp.ui.screens.FireBaseCreateScreen
import com.upn.emptyapp.ui.screens.FireBaseListScreen
import com.upn.emptyapp.ui.screens.ShowCaseScreen
import com.upn.emptyapp.ui.theme.EmptyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EmptyAppTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "registrar_estudiante" // Ruta inicial
                ) {
                    // Aquí definimos cada "pueblo" en nuestro mapa
                    composable("home") {
                        FireBaseListScreen(navController)
                    }

                    composable("registrar_estudiante") {
                        FireBaseCreateScreen(navController)
                    }
                }

            }
        }
    }
}