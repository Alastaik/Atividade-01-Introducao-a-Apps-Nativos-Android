@file:OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)

package com.aula.appsbasicos.ui.screens.exercicios

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import java.util.Locale

@Composable
fun CalculadoraImcScreen(aoVoltar: () -> Unit) {
    var peso by remember { mutableStateOf("") }
    var altura by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }
    var classificacao by remember { mutableStateOf("") }
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Exercício 3 — Calculadora de IMC") },
                navigationIcon = {
                    TextButton(onClick = aoVoltar) {
                        Text("← Voltar")
                    }
                },
            )
        },
    ) { paddingInterno ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingInterno)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
        ) {
            OutlinedTextField(
                value = peso,
                onValueChange = { peso = it },
                label = { Text("Peso (kg)") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
            )

            OutlinedTextField(
                value = altura,
                onValueChange = { altura = it },
                label = { Text("Altura (m) — ex.: 1.75") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth().padding(top = 12.dp),
            )

            Button(
                onClick = {
                    // Peso e altura devem ser positivos.
                    val pesoKg = peso.trim().replace(',', '.').toDoubleOrNull()
                    val alturaM = altura.trim().replace(',', '.').toDoubleOrNull()
                    if (pesoKg == null || alturaM == null ||
                        !pesoKg.isFinite() || !alturaM.isFinite() ||
                        pesoKg <= 0.0 || alturaM <= 0.0
                    ) {
                        resultado = ""
                        classificacao = ""
                        Toast.makeText(context, "Digite peso e altura válidos, maiores que zero", Toast.LENGTH_SHORT).show()
                    } else {
                        val imc = pesoKg / (alturaM * alturaM)
                        if (!imc.isFinite() || imc <= 0.0) {
                            resultado = ""
                            classificacao = ""
                            Toast.makeText(context, "Valores fora do limite de cálculo", Toast.LENGTH_SHORT).show()
                        } else {
                            resultado = String.format(Locale.US, "IMC: %.2f", imc)
                            // Classifica pelo valor antes do arredondamento.
                            classificacao = if (imc < 18.5) {
                                "Abaixo do peso"
                            } else if (imc < 25.0) {
                                "Peso normal"
                            } else if (imc < 30.0) {
                                "Sobrepeso"
                            } else {
                                "Obesidade"
                            }
                        }
                    }
                },
                modifier = Modifier.padding(top = 16.dp),
            ) {
                Text("Calcular")
            }

            Text(
                text = resultado,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(top = 16.dp),
            )
            Text(
                text = classificacao,
                style = MaterialTheme.typography.bodyLarge,
            )
        }
    }
}
