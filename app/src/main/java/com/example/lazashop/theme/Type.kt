package com.example.lazashop.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.lazashop.R


// LAZA Fonts
val Inter_Regular = Font(R.font.inter_regular)
val Inter_Medium = Font(R.font.inter_medium)
val Inter_Bold = Font(R.font.inter_bold)
val Inter_semiBold = Font(R.font.inter_semibold)

// Set of Material typography styles to start with
val Typography = Typography(

    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)
