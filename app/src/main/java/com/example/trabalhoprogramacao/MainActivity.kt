package com.example.trabalhoprogramacao
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TemperatureConverter()
        }
    }
}

@Composable
fun TemperatureConverter() {
    var inputText by remember { mutableStateOf("") }
    var resultText by remember { mutableStateOf("") }
    var colorBack by remember { mutableStateOf(true) }
    var clicado by remember { mutableStateOf(false) }

    val backgroundColor = if (colorBack) Color.LightGray else Color.Gray
    val corDoBotao = if (clicado) Color.Red else Color.Green


    MaterialTheme {
        Surface( modifier = Modifier.fillMaxSize(),
                color = backgroundColor
        ) {
            Column(
                modifier = Modifier.padding(16.dp).fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                TextField(
                    value = inputText,
                    onValueChange = { inputText = it },
                    label = { Text("Coloque a temperatura") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(onClick = {
                    val input = inputText.toDoubleOrNull()
                    resultText = if (input != null) {
                        "Resultado: %.2f °F".format((input * 9 / 5) + 32)
                    } else {
                        "Coloque um valor válido"
                    }
                }) {
                    Text("Celsius para Fahrenheit")
                }

                Spacer(modifier = Modifier.height(8.dp))

                Button(onClick = {
                    val input = inputText.toDoubleOrNull()
                    resultText = if (input != null) {
                        "Resultado: %.2f °C".format((input - 32) * 5 / 9)
                    } else {
                        "Coloque um valor válido"
                    }
                }) {
                    Text("Fahrenheit para Celsius")
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(text = resultText)

                Spacer(modifier = Modifier.height(16.dp))

                Button(onClick = {
                    colorBack = !colorBack
                    clicado = !clicado
                }, colors = ButtonDefaults.buttonColors(containerColor = corDoBotao)) {
                    Text("Mudar Cor de Fundo")
                }
            }
        }
    }
}