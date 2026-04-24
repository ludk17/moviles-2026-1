package com.upn.emptyapp.ui.shared.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object AppColors {
    // Brand Palette
    val Primary = Color(0xFF9C4600)
    val PrimaryContainer = Color(0xFFFFAE80)
    val OnPrimary = Color(0xFFFFFFFF)
    
    val Secondary = Color(0xFF006A6A)

    val Error = Color(0xFFBA1A1A)
    val SecondaryContainer = Color(0xFF70F7F7) // Approximation for on-secondary-container contrast
    val OnSecondaryContainer = Color(0xFF002020)
    
    // Surface Palette (The Sanctuary)
    val Surface = Color(0xFFFFF8F5)
    val SurfaceContainerLow = Color(0xFFFFF1E9)
    val SurfaceContainerHighest = Color(0xFFFFDCC2)
    val OnSurface = Color(0xFF4E2905)
    val OnSurfaceVariant = Color(0xFF85736E) // Approximation
    
    // Semantic & Others
    val OutlineVariant = Color(0xFFE0A677).copy(alpha = 0.15f)
    val ShadowAmbient = Color(0xFF4E2905).copy(alpha = 0.06f)
}

object AppSpacing {
    val none = 0.dp
    val xs = 4.dp
    val sm = 8.dp
    val md = 16.dp
    val lg = 24.dp // 1.5rem
    val xl = 32.dp // 2rem
    val xxl = 48.dp // 3rem
    val xxxl = 64.dp
}

object AppRadius {
    val none = 0.dp
    val sm = 8.dp // 0.5rem
    val md = 24.dp // 1.5rem
    val lg = 32.dp // 2rem
    val xl = 48.dp // 3rem
    val full = 9999.dp
}
