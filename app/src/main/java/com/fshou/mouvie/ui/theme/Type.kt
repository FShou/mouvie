package com.fshou.mouvie.ui.theme

import android.icu.lang.UCharacter.JoiningGroup.HE
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.unit.sp
import com.fshou.mouvie.R

val HELVETICA = Font(R.font.helvetica).toFontFamily()
val HELVETICA_MEDIUM = Font(R.font.helvetica_medium, weight = FontWeight.Medium).toFontFamily()
val CALENDAS_PLUS = Font(R.font.calendas_plus).toFontFamily()
// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = HELVETICA,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = (-0.3).sp
    ),
    titleLarge = TextStyle(
        fontFamily = HELVETICA,
        fontSize = 28.sp,
        lineHeight = 32.sp,
        letterSpacing = (-0.8).sp
    ),
    labelLarge = TextStyle(
        fontFamily = HELVETICA,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.sp
    ),
    displaySmall = TextStyle(
        fontFamily = CALENDAS_PLUS,
        fontSize = 36.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.sp
    )

    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)