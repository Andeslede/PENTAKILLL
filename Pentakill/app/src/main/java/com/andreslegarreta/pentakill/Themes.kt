package com.andreslegarreta.pentakill

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val CustomColor = Color(0x575757) // Reemplaza el valor por el color deseado

private val LightColorPalette = lightColors(
    primary = CustomColor, // Cambia el color primario
    // Otros colores aquí...
)

@Composable
fun PentakillTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = LightColorPalette, // Usa el nuevo color personalizado
        content = content
    )
}

