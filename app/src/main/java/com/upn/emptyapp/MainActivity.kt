package com.upn.emptyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.upn.emptyapp.ui.screens.ShowCaseScreen
import com.upn.emptyapp.ui.theme.EmptyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EmptyAppTheme {
                ShowCaseScreen()
            }
        }
    }
}