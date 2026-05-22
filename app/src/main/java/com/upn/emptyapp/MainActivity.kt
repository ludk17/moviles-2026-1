package com.upn.emptyapp

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.window.SplashScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState
import com.upn.emptyapp.ui.screens.FireBaseCreateScreen
import com.upn.emptyapp.ui.screens.FireBaseListScreen
import com.upn.emptyapp.ui.screens.LoginScreen
import com.upn.emptyapp.ui.theme.EmptyAppTheme
import com.upn.emptyapp.viewModels.PreferencesViewModel
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            EmptyAppTheme {

                val navController = rememberNavController()
                val auth = Firebase.auth

                NavHost(
                    navController = navController,
                    startDestination = "maps"
                ) {

                    composable("maps") {
                        MapScreen()
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
fun MapScreen() {


    // vamos a solicitar el permiso
    val contexto = LocalContext.current
    var permisoGPSOtorgado by remember {
        mutableStateOf(
            // esto pregaunta si se tiene permiso
            ContextCompat.checkSelfPermission(
                contexto, Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        )
    } // retorna true o false

    val lanzadorPermisoGPS = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { aprobado ->
        permisoGPSOtorgado = aprobado
    }

    LaunchedEffect(Unit) {
        if (!permisoGPSOtorgado) {
            lanzadorPermisoGPS.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }

    val scope = rememberCoroutineScope()
    var miUbicacion by remember { mutableStateOf<LatLng?>(null) }
    val latLngPlazaCaj = LatLng(-7.1573675,-78.5166674)
    val fusedClient = remember {
        LocationServices.getFusedLocationProviderClient(contexto)
    }

    val cameraState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(latLngPlazaCaj, 18f)
    }

    LaunchedEffect(Unit) {
        fusedClient.lastLocation
            .addOnSuccessListener { location ->
                if (location != null) {
                    miUbicacion = LatLng(location.latitude, location.longitude)
                    scope.launch {
                        cameraState.animate(
                            CameraUpdateFactory.newLatLngZoom(miUbicacion!!, 13f)
                        )
                    }
                }
            }
    }



    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraState
    ) {
        Marker(
            state = rememberMarkerState(position = latLngPlazaCaj),
        )


    }



}

