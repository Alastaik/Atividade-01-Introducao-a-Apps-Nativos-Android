package com.aula.appsbasicos.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val EsquemaClaro = lightColorScheme(
    primary = AzulDestaque,
    onPrimary = Branco,
    background = Branco,
    onBackground = PretoQuaseTotal,
    surface = Branco,
    onSurface = PretoQuaseTotal,
    surfaceVariant = CinzaClaro,
    onSurfaceVariant = CinzaTexto,
    outline = CinzaBorda,
)

@Composable
fun AppsBasicosTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = EsquemaClaro,
        typography = Typography,
        content = content,
    )
}
