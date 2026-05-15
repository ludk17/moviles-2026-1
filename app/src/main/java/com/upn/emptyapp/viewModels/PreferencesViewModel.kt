package com.upn.emptyapp.viewModels

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.upn.emptyapp.dataStore
import kotlinx.coroutines.launch

class PreferencesViewModel: ViewModel()  {

    var isLogged by mutableStateOf(false)

    fun obtenerSesion(context: Context) {
        viewModelScope.launch {
            context.dataStore.data.collect { preferences ->
                isLogged = preferences[booleanPreferencesKey("sesion")] ?: false
            }
        }
    }

    fun guardarSesion(context: Context) {
        viewModelScope.launch {
            context.dataStore.edit { preferences ->
                preferences[booleanPreferencesKey("sesion")] = true
            }
        }
    }
}