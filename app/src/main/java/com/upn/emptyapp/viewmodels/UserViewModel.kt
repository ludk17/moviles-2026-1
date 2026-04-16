package com.upn.emptyapp.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.upn.emptyapp.http.RetrofitClient
import com.upn.emptyapp.models.Usuario
import com.upn.emptyapp.services.UserApiService
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
    var usuarios by mutableStateOf<List<Usuario>>(emptyList())
    private set
    var isLoading by mutableStateOf(false)
    private set

    var isAuthenticated by mutableStateOf(false)
    var authError by mutableStateOf<String>("")

    fun getAllUsuarios() {
        viewModelScope.launch {
            try {
                isLoading = true
                val instance = RetrofitClient.getService(UserApiService::class.java)
                usuarios = instance.getAllUsers()
                isLoading = false
            } catch (ex: Exception) {
                print(ex);
            }
        }
    }

    fun login(email: String, password: String) {
        viewModelScope.launch {
            Log.i("MAIN_APP", "Login")
            authError = ""
            try {
                val instance = RetrofitClient.getService(UserApiService::class.java)
                usuarios = instance.searchUsersByEmail(email)

                if (usuarios.isEmpty()) {
                    authError = "Usuario y/o contraseña equivocada"
                    return@launch
                }

                val usuario = usuarios[0]
                if (usuario.password == password) {
                    isAuthenticated = true
                } else {
                    authError = "Usuario y/o contraseña equivocada"
                }

            } catch (ex: Exception) {
                authError = "Usuario y/o contraseña equivocada"
            }
        }
    }

}