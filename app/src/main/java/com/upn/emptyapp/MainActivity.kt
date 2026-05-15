package com.upn.emptyapp

import android.content.Context
import android.os.Bundle
import android.window.SplashScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.upn.emptyapp.ui.screens.FireBaseCreateScreen
import com.upn.emptyapp.ui.screens.FireBaseListScreen
import com.upn.emptyapp.ui.screens.LoginScreen
import com.upn.emptyapp.ui.theme.EmptyAppTheme
import com.upn.emptyapp.viewModels.PreferencesViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            EmptyAppTheme {

                val navController = rememberNavController()
                // si usuario esta logueado firsscree = "home"
                // su usuario esta sin loguearse firtScreen = "login"
                val auth = Firebase.auth
//                val firstScreen = if (auth.currentUser == null) "login" else "home"


                NavHost(
                    navController = navController,
                    startDestination = "splash"
                ) {
                    composable("splash") {

                        SplashScreen(navController)

                    }
                    // Pantalla de Login
                    composable("login") {
                        LoginScreen(
                            onLoginClick = { email, password ->
                                // Navegar a la pantalla principal después del login
                                navController.navigate("home")
                            },
                            onRegisterClick = {
                                // Navegar a la pantalla de registro
                                navController.navigate("registrar_estudiante")
                            }
                        )
                    }

                    // Pantalla principal - lista de mascotas
                    composable("home") {
                        FireBaseListScreen(navController)
                    }

                    // Pantalla de registro
                    composable("registrar_estudiante") {
                        FireBaseCreateScreen(navController)
                    }
                }
            }
        }
    }
}

@Composable
fun SplashScreen(navController: NavController,
                 viewModel: PreferencesViewModel = viewModel()) {
    val context: Context = LocalContext.current
    val auth = Firebase.auth
    LaunchedEffect(Unit) {
        viewModel.obtenerSesion(context)
        if (viewModel.isLogged) {
            navController.navigate("home")
        } else {
            navController.navigate("login")
        }
    }
        Text("Hello")

}
