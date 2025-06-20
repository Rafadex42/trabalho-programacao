package com.example.trabalhoprogramacao
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier


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

    MaterialTheme {
        Surface( modifier = Modifier.fillMaxSize() ) {
            Column() {
                TextField(
                    value = inputText,
                    onValueChange = { inputText = it },
                    label = { Text("Coloque a temperatura") },
                    modifier = Modifier.fillMaxWidth()
                )

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

                Text(text = resultText)

            }
        }
    }
}