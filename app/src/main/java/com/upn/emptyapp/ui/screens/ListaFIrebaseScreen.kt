package com.upn.emptyapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.upn.emptyapp.ui.shared.theme.AppColors

@Composable
fun ListaFirebaseScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = AppColors.Surface
    ) { paddingValues ->



        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            LazyColumn {

            }
        }

    }
}