package com.upn.emptyapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.upn.emptyapp.models.Usuario
import com.upn.emptyapp.services.UserApiService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.upn.emptyapp.http.RetrofitClient
import com.upn.emptyapp.viewmodels.UserViewModel

@Composable
fun HomeScreen(viewModel: UserViewModel = viewModel() ) {

    LaunchedEffect(Unit) {
        viewModel.getAllUsuarios()
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Button(onClick = {

        }, modifier = Modifier.padding(bottom = 16.dp)) {
            Text("Crear Usuario")
        }

        if (viewModel.isLoading) {
            CircularProgressIndicator()
        } else {

            LazyColumn {
                items(viewModel.usuarios) { user ->
                    Card(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(vertical = 4.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(text = user.name)
                            Text(text = user.email)
                        }
                    }
                }
            }
        }

    }
}
