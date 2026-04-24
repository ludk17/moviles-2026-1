package com.upn.emptyapp.ui.screens.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.upn.emptyapp.ui.shared.components.*
import com.upn.emptyapp.ui.shared.theme.AppColors
import com.upn.emptyapp.ui.shared.theme.AppSpacing

@Composable
fun LoginPage() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = AppColors.Surface
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(AppSpacing.lg),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(AppSpacing.xxl))

            // Asymmetrical Logo Section
            Box(
                modifier = Modifier
                    .size(120.dp),
                contentAlignment = Alignment.Center
            ) {
                // Heart shape (asymmetrical placement)
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .offset(x = 20.dp, y = (-10).dp),
                    tint = AppColors.SurfaceContainerHighest
                )
                // Main Circle with Paw
                Box(
                    modifier = Modifier
                        .size(70.dp)
                        .offset(x = (-20).dp, y = 10.dp)
                        .clip(CircleShape)
                        .background(AppColors.Primary),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Pets,
                        contentDescription = null,
                        modifier = Modifier.size(32.dp),
                        tint = Color.White
                    )
                }
            }

            Spacer(modifier = Modifier.height(AppSpacing.md))
            
            AppHeadline(text = "Paws & Homes")
            
            Spacer(modifier = Modifier.height(AppSpacing.xl))

            AppDisplay(text = "Welcome back!")
            AppBody(
                text = "Your sanctuary and its residents missed you.",
                modifier = Modifier.padding(top = AppSpacing.sm)
            )

            Spacer(modifier = Modifier.height(AppSpacing.xxl))

            // Form
            Column(modifier = Modifier.fillMaxWidth()) {
                AppInput(
                    value = email,
                    onValueChange = { email = it },
                    label = "Email",
                    placeholder = "hello@example.com",
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Email,
                            contentDescription = null,
                            tint = AppColors.OnSurfaceVariant
                        )
                    }
                )

                Spacer(modifier = Modifier.height(AppSpacing.md))

                Box(modifier = Modifier.fillMaxWidth()) {
                    AppInput(
                        value = password,
                        onValueChange = { password = it },
                        label = "Password",
                        placeholder = "••••••••",
                        isPassword = true,
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Outlined.Lock,
                                contentDescription = null,
                                tint = AppColors.OnSurfaceVariant
                            )
                        },
                        trailingIcon = {
                            Icon(
                                imageVector = Icons.Outlined.Visibility,
                                contentDescription = null,
                                tint = AppColors.OnSurfaceVariant
                            )
                        }
                    )
                    
                    // Forgot Password Link
                    Text(
                        text = "Forgot Password?",
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(top = 0.dp) // Aligned with label area
                            .clickable { },
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = AppColors.Primary
                    )
                }

                Spacer(modifier = Modifier.height(AppSpacing.xl))

                AppButton(
                    text = "Login",
                    onClick = { /* Handle login */ }
                )
            }

            Spacer(modifier = Modifier.height(AppSpacing.xl))

            // Divider Section
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                HorizontalDivider(modifier = Modifier.weight(1f), color = AppColors.OutlineVariant)
                AppLabel(
                    text = " Or continue with ",
                    modifier = Modifier.padding(horizontal = AppSpacing.sm)
                )
                HorizontalDivider(modifier = Modifier.weight(1f), color = AppColors.OutlineVariant)
            }

            Spacer(modifier = Modifier.height(AppSpacing.xl))

            // Social Login Buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(AppSpacing.md)
            ) {
                SocialButton(
                    icon = Icons.Default.GTranslate, // Placeholder for Google
                    text = "Google",
                    modifier = Modifier.weight(1f)
                )
                SocialButton(
                    icon = Icons.Default.Facebook,
                    text = "Facebook",
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(AppSpacing.xxl))

            // Footer
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                AppBody(text = "Don't have an account? ")
                Text(
                    text = "Sign Up",
                    fontWeight = FontWeight.Bold,
                    color = AppColors.Primary,
                    modifier = Modifier.clickable { }
                )
            }
            
            Spacer(modifier = Modifier.height(AppSpacing.xxl))
        }
    }
}

@Composable
fun SocialButton(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    text: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(56.dp)
            .clip(RoundedCornerShape(com.upn.emptyapp.ui.shared.theme.AppRadius.md))
            .background(Color.White)
            .border(
                1.dp,
                AppColors.OutlineVariant,
                RoundedCornerShape(com.upn.emptyapp.ui.shared.theme.AppRadius.md)
            )
            .clickable { },
        contentAlignment = Alignment.Center
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = if (text == "Facebook") Color(0xFF1877F2) else Color.Unspecified
            )
            Spacer(modifier = Modifier.width(AppSpacing.sm))
            AppTitle(text = text)
        }
    }
}
