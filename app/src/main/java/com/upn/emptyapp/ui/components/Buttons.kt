package com.upn.emptyapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.upn.emptyapp.ui.theme.PrimaryGradientEnd
import com.upn.emptyapp.ui.theme.PrimaryGradientStart
import com.upn.emptyapp.ui.theme.SanctuaryTheme

@Composable
fun AppButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isSecondary: Boolean = false
) {
    val shape = RoundedCornerShape(SanctuaryTheme.Radius.full)
    
    if (isSecondary) {
        Box(
            modifier = modifier
                .clip(shape)
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .clickable { onClick() }
                .padding(horizontal = 24.dp, vertical = 12.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontWeight = FontWeight.Bold
            )
        }
    } else {
        Box(
            modifier = modifier
                .clip(shape)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(PrimaryGradientStart, PrimaryGradientEnd)
                    )
                )
                .clickable { onClick() }
                .padding(horizontal = 24.dp, vertical = 12.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.labelLarge,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
