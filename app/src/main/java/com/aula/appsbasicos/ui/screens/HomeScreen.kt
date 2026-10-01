@file:OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)

package com.aula.appsbasicos.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class ItemMenu(
    val titulo: String,
    val descricao: String,
    val aoClicar: () -> Unit,
)

data class SecaoMenu(
    val titulo: String,
    val itens: List<ItemMenu>,
)

@Composable
fun HomeScreen(
    aoAbrirCalculadora: () -> Unit,
    aoAbrirCadastro: () -> Unit,
    aoAbrirConversorTemperatura: () -> Unit,
    aoAbrirLogin: () -> Unit,
    aoAbrirCalculadoraImc: () -> Unit,
) {
    val secoes = listOf(
        SecaoMenu(
            titulo = "Exemplos — 1º horário",
            itens = listOf(
                ItemMenu(
                    titulo = "Calculadora Simples",
                    descricao = "Estado, TextField e validação de entrada.",
                    aoClicar = aoAbrirCalculadora,
                ),
                ItemMenu(
                    titulo = "Cadastro com Navegação",
                    descricao = "Duas telas conectadas por Navigation Compose.",
                    aoClicar = aoAbrirCadastro,
                ),
            ),
        ),
        SecaoMenu(
            titulo = "Atividade 01 — Exercícios",
            itens = listOf(
                ItemMenu(
                    titulo = "Conversor de Temperatura",
                    descricao = "Converte Celsius para Fahrenheit.",
                    aoClicar = aoAbrirConversorTemperatura,
                ),
                ItemMenu(
                    titulo = "Login com Navegação",
                    descricao = "Valida o nome e exibe as boas-vindas.",
                    aoClicar = aoAbrirLogin,
                ),
                ItemMenu(
                    titulo = "Calculadora de IMC (desafio)",
                    descricao = "Calcula o IMC e exibe a classificação.",
                    aoClicar = aoAbrirCalculadoraImc,
                ),
            ),
        ),
    )

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Apps Básicos — Android Studio") })
        },
    ) { paddingInterno ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingInterno)
                .padding(horizontal = 16.dp, vertical = 8.dp),
        ) {
            secoes.forEach { secao ->
                item {
                    Text(
                        text = secao.titulo,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(top = 16.dp, bottom = 8.dp),
                    )
                }
                items(secao.itens) { item ->
                    ItemMenuCard(item)
                }
            }
        }
    }
}

@Composable
private fun ItemMenuCard(item: ItemMenu) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp)
            .clickable(onClick = item.aoClicar),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = item.titulo, style = MaterialTheme.typography.bodyLarge)
            Text(text = item.descricao, style = MaterialTheme.typography.bodyMedium)
        }
    }
}
