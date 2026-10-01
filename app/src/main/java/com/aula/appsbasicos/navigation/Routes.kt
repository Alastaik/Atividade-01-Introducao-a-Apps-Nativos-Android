package com.aula.appsbasicos.navigation

import kotlinx.serialization.Serializable

@Serializable
object Home


@Serializable
object Calculadora

@Serializable
object Cadastro

@Serializable
data class BoasVindas(val nome: String, val idade: String)


@Serializable
object ConversorTemperatura

@Serializable
object Login

@Serializable
data class BoasVindasLogin(val nome: String)

@Serializable
object CalculadoraImc
