package com.upn.emptyapp.ui.screens.pages

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.upn.emptyapp.ui.shared.components.*
import com.upn.emptyapp.ui.shared.theme.AppColors
import com.upn.emptyapp.ui.shared.theme.AppSpacing

@Composable
fun ShowCasePage() {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = AppColors.Surface
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(AppSpacing.lg)
        ) {
            AppDisplay(text = "Digital Sanctuary")
            AppBody(
                text = "The Compassionate Curator Design System", 
                modifier = Modifier.padding(bottom = AppSpacing.xl)
            )

            AppSection(title = "Typography") {
                AppHeadline(text = "Editorial Headlines")
                Spacer(modifier = Modifier.height(AppSpacing.sm))
                AppTitle(text = "Authoritative Card Titles")
                Spacer(modifier = Modifier.height(AppSpacing.sm))
                AppBody(text = "Generous line-height for body text ensures a relaxed and compassionate reading experience.")
            }

            Spacer(modifier = Modifier.height(AppSpacing.xxl))

            AppSection(title = "Forms") {
                AppInput(
                    value = name,
                    onValueChange = { name = it },
                    label = "Full Name",
                    placeholder = "Enter your name"
                )
                Spacer(modifier = Modifier.height(AppSpacing.md))
                AppInput(
                    value = email,
                    onValueChange = { email = it },
                    label = "Email Address",
                    placeholder = "hello@foreverfriend.com",
                    isError = email.isNotEmpty() && !email.contains("@")
                )
            }

            Spacer(modifier = Modifier.height(AppSpacing.xxl))

            AppSection(title = "Elevation & Chips") {
                Row(horizontalArrangement = Arrangement.spacedBy(AppSpacing.sm)) {
                    AppChip(text = "Vaccinated")
                    AppChip(text = "Friendly")
                    AppChip(text = "House Trained")
                }
                Spacer(modifier = Modifier.height(AppSpacing.lg))
                AppCard {
                    AppTitle(text = "Premium Stationery")
                    AppBody(text = "We reject heavy shadows. Depth is achieved through layering surface tokens.")
                }
            }

            Spacer(modifier = Modifier.height(AppSpacing.xxl))

            AppSection(title = "Actions") {
                AppButton(text = "Adopt Now", onClick = { })
                Spacer(modifier = Modifier.height(AppSpacing.md))
                AppSecondaryButton(text = "Save for Later", onClick = { })
                Spacer(modifier = Modifier.height(AppSpacing.md))
                AppGhostButton(text = "Share Story", onClick = { })
            }
        }
    }
}
