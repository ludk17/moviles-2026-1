package com.upn.emptyapp.ui.shared.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.upn.emptyapp.ui.shared.theme.AppColors
import com.upn.emptyapp.ui.shared.theme.AppRadius
import com.upn.emptyapp.ui.shared.theme.AppSpacing

@Composable
fun AppInput(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier,
    label: String? = null,
    isError: Boolean = false,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    isPassword: Boolean = false
) {
    Column(modifier = modifier) {
        if (label != null) {
            AppInputLabel(text = label)
        }
        
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .clip(RoundedCornerShape(AppRadius.md))
                .background(AppColors.SurfaceContainerLow)
                .border(
                    width = 1.dp,
                    color = if (isError) AppColors.Error else AppColors.OutlineVariant,
                    shape = RoundedCornerShape(AppRadius.md)
                ),
            visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
            cursorBrush = SolidColor(AppColors.Primary),
            textStyle = androidx.compose.ui.text.TextStyle(
                color = AppColors.OnSurface,
                fontSize = 16.sp
            ),
            decorationBox = { innerTextField ->
                Row(
                    modifier = Modifier.padding(horizontal = AppSpacing.lg),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (leadingIcon != null) {
                        leadingIcon()
                        Spacer(modifier = Modifier.width(AppSpacing.sm))
                    }
                    
                    Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.CenterStart) {
                        if (value.isEmpty()) {
                            AppBody(text = placeholder, color = AppColors.OnSurfaceVariant)
                        }
                        innerTextField()
                    }
                    
                    if (trailingIcon != null) {
                        Spacer(modifier = Modifier.width(AppSpacing.sm))
                        trailingIcon()
                    }
                }
            }
        )
    }
}
