package com.upn.emptyapp.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.upn.emptyapp.http.RetrofitClient
import com.upn.emptyapp.models.Usuario
import kotlinx.coroutines.launch

class UsuarioViewModel: ViewModel() {

    var estCargandoListaUsuarios by mutableStateOf(false)
    var usuarios by mutableStateOf(listOf<Usuario>())
    private set

    fun loadUsers() {
        estCargandoListaUsuarios = true
        viewModelScope.launch {
            usuarios = RetrofitClient.instance.getAllUsers()
            estCargandoListaUsuarios = false
        }
    }

    fun createUser(user: Usuario) {
        viewModelScope.launch {
            RetrofitClient.instance.createUser(user)
        }
    }
}