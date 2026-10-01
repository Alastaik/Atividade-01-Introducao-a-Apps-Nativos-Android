# Atividade 01 — Introdução a Apps Nativos Android

Resolução dos três exercícios com Kotlin e Jetpack Compose, usando o projeto fornecido no ZIP.

## Exercícios

1. **Temperatura:** Celsius para Fahrenheit, com duas casas decimais e Toast para entrada inválida.
2. **Login:** valida o nome, envia pela rota `@Serializable` e exibe as boas-vindas. **Sair** retorna ao login.
3. **IMC:** valida peso e altura positivos, calcula `peso / (altura * altura)` e exibe valor e classificação.

| IMC | Classificação da apostila |
| --- | --- |
| Menor que 18,5 | Abaixo do peso |
| De 18,5 até menos de 25 | Peso normal |
| De 25 até menos de 30 | Sobrepeso |
| A partir de 30 | Obesidade |

Os números aceitam ponto ou vírgula. A classificação usa o IMC antes do arredondamento.
Os exemplos de calculadora e cadastro fornecidos na aula continuam no menu.

## Executar

1. No Android Studio, use **File > Open** e selecione a pasta do repositório.
2. Aguarde a sincronização do Gradle.
3. Selecione um emulador ou celular com Android 8.0 ou superior.
4. Execute o módulo **app**.

Requisitos: SDK 35 e JDK 17 ou 21. Versões mantidas do projeto original: AGP 8.7.3, Kotlin 2.0.21 e Gradle 8.10.2.

No Windows, clone em uma pasta sem acentos, como `C:\Projetos\Atividade01Android`.
O plugin Android bloqueia a compilação em caminhos com acentos.

```powershell
.\gradlew.bat assembleDebug lintDebug
```

APK: `app/build/outputs/apk/debug/app-debug.apk`.

## Organização

- `ui/screens/exercicios/`: resolução dos exercícios.
- `navigation/`: rotas e navegação.
- `ui/screens/exemplos/`: exemplos da aula.
- `ui/theme/`: cores e fontes.

## Conferência manual

| Tela | Entrada | Resultado esperado |
| --- | --- | --- |
| Temperatura | 0 | 32.00 °F |
| Temperatura | 37 | 98.60 °F |
| Temperatura | -40 | -40.00 °F |
| Temperatura | Vazio ou texto | Toast de erro |
| Login | Apenas espaços | Toast e permanência no login |
| Login | Ana | Bem-vindo(a), Ana! |
| Boas-vindas | Sair | Retorno ao login |
| IMC | 70 kg e 1,75 m | IMC: 22.86; Peso normal |
| IMC | 18,5 kg e 1 m | Peso normal |
| IMC | 25 kg e 1 m | Sobrepeso |
| IMC | 30 kg e 1 m | Obesidade |
| IMC | Zero, negativo ou texto | Toast de erro |

O registro das verificações executadas está em `VALIDACAO.md`.

Testes automatizados das telas, com um emulador iniciado:

```powershell
.\gradlew.bat connectedDebugAndroidTest
```
