@file:OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)

package com.aula.appsbasicos.ui.screens.exercicios

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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

@Composable
fun LoginScreen(
    aoEntrar: (nome: String) -> Unit,
    aoVoltar: () -> Unit,
) {
    var usuario by remember { mutableStateOf("") }
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Exercício 2 — Login") },
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
                value = usuario,
                onValueChange = { usuario = it },
                label = { Text("Nome de usuário") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
            )

            Button(
                onClick = {
                    // Só navega quando o nome está preenchido.
                    val nome = usuario.trim()
                    if (nome.isBlank()) {
                        Toast.makeText(context, "Digite o nome de usuário", Toast.LENGTH_SHORT).show()
                    } else {
                        aoEntrar(nome)
                    }
                },
                modifier = Modifier.padding(top = 16.dp),
            ) {
                Text("Entrar")
            }

        }
    }
}
