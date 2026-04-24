package com.upn.emptyapp.ui.shared.components

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.upn.emptyapp.ui.shared.theme.AppSpacing

@Composable
fun AppInputLabel(
    text: String,
    modifier: Modifier = Modifier,
    isRequired: Boolean = false
) {
    AppLabel(
        text = if (isRequired) "$text *" else text,
        modifier = modifier.padding(bottom = AppSpacing.sm)
    )
}
