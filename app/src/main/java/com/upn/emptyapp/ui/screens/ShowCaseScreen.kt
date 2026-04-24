package com.upn.emptyapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.upn.emptyapp.ui.components.*
import com.upn.emptyapp.ui.theme.SanctuaryTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowCaseScreen() {
    var textValue by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { 
                    Text(
                        "Design System Showcase",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    ) 
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(scrollState)
                .padding(SanctuaryTheme.Spacing.lg)
        ) {
            // Typography Section
            AppLabel("Typography")
            AppDisplay("Display Large")
            Spacer(modifier = Modifier.height(8.dp))
            AppHeadline("Headline Large")
            Spacer(modifier = Modifier.height(8.dp))
            AppTitle("Title Large (Card Header)")
            Spacer(modifier = Modifier.height(8.dp))
            AppBody("Body Large - This is the editorial body text with generous line height for a relaxed reading experience.")
            
            AppDivider(modifier = Modifier.padding(vertical = SanctuaryTheme.Spacing.xl))

            // Buttons Section
            AppLabel("Buttons")
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                AppButton(text = "Primary Button", onClick = {})
                AppButton(text = "Secondary", onClick = {}, isSecondary = true)
            }

            AppDivider(modifier = Modifier.padding(vertical = SanctuaryTheme.Spacing.xl))

            // Inputs Section
            AppLabel("Inputs")
            AppInput(
                value = textValue,
                onValueChange = { textValue = it },
                label = "Pet Name",
                placeholder = "Enter the name..."
            )

            AppDivider(modifier = Modifier.padding(vertical = SanctuaryTheme.Spacing.xl))

            // Cards & Chips Section
            AppLabel("Cards & Chips")
            AppCard(modifier = Modifier.fillMaxWidth()) {
                AppTitle("Adopt Luna")
                Spacer(modifier = Modifier.height(8.dp))
                AppBody(
                    "A friendly golden retriever looking for a home.",
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    AppChip(text = "Vaccinated")
                    AppChip(text = "Friendly")
                    AppChip(text = "2 Years")
                }
            }

            Spacer(modifier = Modifier.height(SanctuaryTheme.Spacing.xxl))
        }
    }
}

@Composable
fun AppDivider(modifier: Modifier = Modifier) {
    HorizontalDivider(
        modifier = modifier,
        thickness = DividerDefaults.Thickness,
        color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)
    )
}
