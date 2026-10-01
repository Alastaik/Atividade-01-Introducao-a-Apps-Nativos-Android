# Validação

Executada em 1 de outubro de 2026.

- `assembleDebug`: aprovado; APK gerado.
- `lintDebug`: aprovado, sem erros. Há avisos sobre versões disponíveis, ícone do aplicativo e dependências de teste fora do catálogo.
- `connectedDebugAndroidTest`: 3 testes aprovados no emulador Pixel 6 com Android 15.

Os testes exercitam as telas reais: conversão de temperatura, rejeição de texto, login vazio, envio de nome pela rota, retorno ao login, IMC com vírgula, limites das classificações e rejeição de altura zero.

Ambiente: Windows, JDK 21, SDK 35 e Gradle 8.10.2. A compilação ocorreu em uma cópia com caminho sem acentos, devido à restrição do plugin Android no Windows.

Os testes não fazem inspeção visual do layout nem verificam o texto dos Toasts. O README inclui os casos para conferência manual.
