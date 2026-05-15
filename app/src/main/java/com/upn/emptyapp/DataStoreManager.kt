package com.upn.emptyapp

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

// Extensión que crea el DataStore con nombre "mis_preferencias"
// dataStore es solo un nombre para indetificarlo
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "mis_preferencias")