package com.aula.appsbasicos.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.aula.appsbasicos.ui.screens.HomeScreen
import com.aula.appsbasicos.ui.screens.exemplos.BoasVindasScreen
import com.aula.appsbasicos.ui.screens.exemplos.CadastroScreen
import com.aula.appsbasicos.ui.screens.exemplos.CalculadoraScreen
import com.aula.appsbasicos.ui.screens.exercicios.BoasVindasLoginScreen
import com.aula.appsbasicos.ui.screens.exercicios.CalculadoraImcScreen
import com.aula.appsbasicos.ui.screens.exercicios.ConversorTemperaturaScreen
import com.aula.appsbasicos.ui.screens.exercicios.LoginScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Home) {
        composable<Home> {
            HomeScreen(
                aoAbrirCalculadora = { navController.navigate(Calculadora) },
                aoAbrirCadastro = { navController.navigate(Cadastro) },
                aoAbrirConversorTemperatura = { navController.navigate(ConversorTemperatura) },
                aoAbrirLogin = { navController.navigate(Login) },
                aoAbrirCalculadoraImc = { navController.navigate(CalculadoraImc) },
            )
        }

        // Exemplos da aula.

        composable<Calculadora> {
            CalculadoraScreen(aoVoltar = { navController.popBackStack() })
        }

        composable<Cadastro> {
            CadastroScreen(
                aoContinuar = { nome, idade ->
                    navController.navigate(BoasVindas(nome = nome, idade = idade))
                },
                aoVoltar = { navController.popBackStack() },
            )
        }

        composable<BoasVindas> { backStackEntry ->
            val dados: BoasVindas = backStackEntry.toRoute()
            BoasVindasScreen(
                nome = dados.nome,
                idade = dados.idade,
                aoVoltar = { navController.popBackStack() },
            )
        }

        // Exercícios da atividade.

        composable<ConversorTemperatura> {
            ConversorTemperaturaScreen(aoVoltar = { navController.popBackStack() })
        }

        composable<Login> {
            LoginScreen(
                aoEntrar = { nome -> navController.navigate(BoasVindasLogin(nome = nome)) },
                aoVoltar = { navController.popBackStack() },
            )
        }

        composable<BoasVindasLogin> { backStackEntry ->
            val dados: BoasVindasLogin = backStackEntry.toRoute()
            BoasVindasLoginScreen(
                nome = dados.nome,
                aoVoltar = { navController.popBackStack() },
            )
        }

        composable<CalculadoraImc> {
            CalculadoraImcScreen(aoVoltar = { navController.popBackStack() })
        }
    }
}
