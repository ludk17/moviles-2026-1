package com.upn.emptyapp.ui.shared.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.upn.emptyapp.ui.shared.theme.AppColors
import com.upn.emptyapp.ui.shared.theme.AppRadius
import com.upn.emptyapp.ui.shared.theme.AppSpacing

@Composable
fun AppChip(
    text: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(AppRadius.full))
            .background(AppColors.SecondaryContainer)
            .padding(horizontal = AppSpacing.md, vertical = AppSpacing.xs)
    ) {
        AppLabel(
            text = text,
            color = AppColors.OnSecondaryContainer
        )
    }
}
