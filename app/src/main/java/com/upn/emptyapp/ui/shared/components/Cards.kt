package com.upn.emptyapp.ui.shared.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.upn.emptyapp.ui.shared.theme.AppColors
import com.upn.emptyapp.ui.shared.theme.AppRadius
import com.upn.emptyapp.ui.shared.theme.AppSpacing

@Composable
fun AppCard(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.White, // Premium stationery feel
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(AppRadius.md))
            .background(backgroundColor)
            .padding(AppSpacing.lg), // 1.5rem spacing
        content = content
    )
}

@Composable
fun AppSection(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(modifier = modifier.fillMaxWidth()) {
        AppHeadline(
            text = title,
            modifier = Modifier.padding(bottom = AppSpacing.lg)
        )
        AppCard(content = content)
    }
}
