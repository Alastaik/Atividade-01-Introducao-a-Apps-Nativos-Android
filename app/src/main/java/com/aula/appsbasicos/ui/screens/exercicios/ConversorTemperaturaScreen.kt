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
fun ConversorTemperaturaScreen(aoVoltar: () -> Unit) {
    var celsius by remember { mutableStateOf("") }
    var fahrenheit by remember { mutableStateOf("") }
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Exercício 1 — Conversor de Temperatura") },
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
                value = celsius,
                onValueChange = { celsius = it },
                label = { Text("Temperatura em Celsius") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
            )

            Button(
                onClick = {
                    // Valida a entrada antes da conversão.
                    val valor = celsius.trim().replace(',', '.').toDoubleOrNull()
                    val convertido = valor?.let { it * 9.0 / 5.0 + 32.0 }
                    if (convertido == null || !convertido.isFinite()) {
                        fahrenheit = ""
                        Toast.makeText(context, "Digite uma temperatura válida", Toast.LENGTH_SHORT).show()
                    } else {
                        fahrenheit = String.format(Locale.US, "%.2f °F", convertido)
                    }
                },
                modifier = Modifier.padding(top = 16.dp),
            ) {
                Text("Converter")
            }

            Text(
                text = fahrenheit,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(top = 16.dp),
            )

        }
    }
}
