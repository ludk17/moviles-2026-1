package com.upn.emptyapp.ui.shared.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.upn.emptyapp.ui.shared.theme.AppColors
import com.upn.emptyapp.ui.shared.theme.AppRadius
import com.upn.emptyapp.ui.shared.theme.AppSpacing

@Composable
fun AppButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true
) {
    val gradient = Brush.linearGradient(
        colors = listOf(AppColors.Primary, AppColors.PrimaryContainer),
        start = androidx.compose.ui.geometry.Offset(0f, 0f),
        end = androidx.compose.ui.geometry.Offset(1000f, 1000f) // Approximation of 135deg
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(RoundedCornerShape(AppRadius.full))
            .then(
                if (isEnabled) Modifier.background(gradient)
                else Modifier.background(AppColors.OnSurfaceVariant.copy(alpha = 0.3f))
            )
            .clickable(enabled = isEnabled, onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        AppTitle(
            text = text,
            color = AppColors.OnPrimary
        )
    }
}

@Composable
fun AppSecondaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(RoundedCornerShape(AppRadius.full))
            .background(if (isEnabled) AppColors.SecondaryContainer else AppColors.SurfaceContainerLow)
            .clickable(enabled = isEnabled, onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        AppTitle(
            text = text,
            color = AppColors.OnSecondaryContainer
        )
    }
}

@Composable
fun AppGhostButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(RoundedCornerShape(AppRadius.full))
            .clickable(enabled = isEnabled, onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        AppTitle(
            text = text,
            color = AppColors.Primary
        )
    }
}
