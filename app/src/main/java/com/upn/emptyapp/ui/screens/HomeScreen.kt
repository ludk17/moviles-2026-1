package com.upn.emptyapp.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.upn.emptyapp.http.RetrofitClient
import com.upn.emptyapp.models.Usuario
import com.upn.emptyapp.viewmodels.UsuarioViewModel

@Composable
fun HomeScreen(viewModel: UsuarioViewModel = viewModel()) {

   // llamada asincrona, se ejecuta una vez
   LaunchedEffect(Unit) {
      viewModel.loadUsers()
   }

   Button(onClick = {
      val user = Usuario(0, "John", "Doe")
      viewModel.createUser(user)
   }) {
      Text("Clic Me")
   }

   if (viewModel.estCargandoListaUsuarios) {
    CircularProgressIndicator()
   } else {

      LazyColumn {
         items(viewModel.usuarios) { user ->
            Text(text = user.name)
         }
      }
   }
}
