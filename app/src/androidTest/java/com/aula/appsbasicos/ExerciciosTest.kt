package com.aula.appsbasicos

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.performTextReplacement
import org.junit.Rule
import org.junit.Test

class ExerciciosTest {
    @get:Rule
    val compose = createAndroidComposeRule<MainActivity>()

    @Test
    fun temperaturaConverteERecusaTexto() {
        compose.onNodeWithText("Conversor de Temperatura").performClick()
        compose.onNodeWithText("Temperatura em Celsius").performTextInput("37")
        compose.onNodeWithText("Converter").performClick()
        compose.onNodeWithText("98.60 °F").assertIsDisplayed()
        compose.onNodeWithText("Temperatura em Celsius").performTextReplacement("-40")
        compose.onNodeWithText("Converter").performClick()
        compose.onNodeWithText("-40.00 °F").assertIsDisplayed()
        compose.onNodeWithText("Temperatura em Celsius").performTextReplacement("abc")
        compose.onNodeWithText("Converter").performClick()
        compose.onNodeWithText("Temperatura em Celsius").assertIsDisplayed()
        compose.onNodeWithText("-40.00 °F").assertDoesNotExist()
    }

    @Test
    fun loginValidaNomeNavegaERetorna() {
        compose.onNodeWithText("Login com Navegação").performClick()
        compose.onNodeWithText("Nome de usuário").performTextInput("   ")
        compose.onNodeWithText("Entrar").performClick()
        compose.onNodeWithText("Nome de usuário").assertIsDisplayed()
        compose.onNodeWithText("Nome de usuário").performTextReplacement(" Ana / Silva ")
        compose.onNodeWithText("Entrar").performClick()
        compose.onNodeWithText("Bem-vindo(a), Ana / Silva!").assertIsDisplayed()
        compose.onNodeWithText("Sair").performClick()
        compose.onNodeWithText("Nome de usuário").assertIsDisplayed()
    }

    @Test
    fun imcCalculaClassificaERecusaZero() {
        compose.onNodeWithText("Calculadora de IMC (desafio)").performClick()
        compose.onNodeWithText("Peso (kg)").performTextInput("70")
        compose.onNodeWithText("Altura (m) — ex.: 1.75").performTextInput("1,75")
        compose.onNodeWithText("Calcular").performClick()
        compose.onNodeWithText("IMC: 22.86").assertIsDisplayed()
        compose.onNodeWithText("Peso normal").assertIsDisplayed()
        compose.onNodeWithText("Altura (m) — ex.: 1.75").performTextReplacement("1")
        for ((peso, categoria) in listOf("18" to "Abaixo do peso", "18.5" to "Peso normal", "25" to "Sobrepeso", "30" to "Obesidade")) {
            compose.onNodeWithText("Peso (kg)").performTextReplacement(peso)
            compose.onNodeWithText("Calcular").performClick()
            compose.onNodeWithText(categoria).assertIsDisplayed()
        }
        compose.onNodeWithText("Altura (m) — ex.: 1.75").performTextReplacement("0")
        compose.onNodeWithText("Calcular").performClick()
        compose.onNodeWithText("Obesidade").assertDoesNotExist()
    }
}
