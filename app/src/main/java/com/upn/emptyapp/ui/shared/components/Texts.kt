package com.upn.emptyapp.ui.shared.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.upn.emptyapp.ui.shared.theme.AppColors

@Composable
fun AppDisplay(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = AppColors.OnSurface
) {
    Text(
        text = text,
        modifier = modifier,
        fontSize = 36.sp,
        fontWeight = FontWeight.Bold,
        color = color,
        lineHeight = 44.sp,
        letterSpacing = (-0.02).sp // Editorial tight spacing
    )
}

@Composable
fun AppHeadline(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = AppColors.OnSurface
) {
    Text(
        text = text,
        modifier = modifier,
        fontSize = 28.sp,
        fontWeight = FontWeight.SemiBold,
        color = color,
        lineHeight = 36.sp,
        letterSpacing = (-0.02).sp
    )
}

@Composable
fun AppTitle(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = AppColors.OnSurface
) {
    Text(
        text = text,
        modifier = modifier,
        fontSize = 20.sp,
        fontWeight = FontWeight.Medium,
        color = color,
        lineHeight = 28.sp
    )
}

@Composable
fun AppBody(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = AppColors.OnSurface
) {
    Text(
        text = text,
        modifier = modifier,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        color = color,
        lineHeight = 26.sp // Generous 1.6x line height
    )
}

@Composable
fun AppLabel(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = AppColors.OnSurfaceVariant
) {
    Text(
        text = text,
        modifier = modifier,
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        color = color,
        lineHeight = 20.sp
    )
}
