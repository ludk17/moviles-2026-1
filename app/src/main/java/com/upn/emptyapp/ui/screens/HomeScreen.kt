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
import com.upn.emptyapp.models.Usuario
import com.upn.emptyapp.services.UserApiService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.upn.emptyapp.http.RetrofitClient

@Composable
fun HomeScreen() {
    var isLoading by remember { mutableStateOf(true) }
    var isRefreshing by remember { mutableStateOf(false) }
    var usuarios by remember { mutableStateOf<List<Usuario>>(emptyList()) }
    val coroutineScope = rememberCoroutineScope()

    val apiService = remember {
        RetrofitClient.getService(UserApiService::class.java)
    }

    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing)

    val fetchUsers: () -> Unit = {
        coroutineScope.launch {
            isLoading = true
            isRefreshing = true
            usuarios = apiService.getAllUsers()
            isLoading = false
            isRefreshing = false
        }
    }

    LaunchedEffect(Unit) {
        fetchUsers()
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Button(onClick = {
            coroutineScope.launch {
                apiService.create(Usuario(0, "luis", "luis@email.com"))
                // After creating a user, you might want to refresh the list
                fetchUsers()
            }
        }, modifier = Modifier.padding(bottom = 16.dp)) {
            Text("Crear Usuario")
        }

        if (isLoading && !isRefreshing) {
            CircularProgressIndicator()
        } else {
            SwipeRefresh(state = swipeRefreshState, onRefresh = fetchUsers) {
                LazyColumn {
                    items(usuarios) { user ->
                        Card(modifier = Modifier
                            .fillMaxSize()
                            .padding(vertical = 4.dp)) {
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
}
