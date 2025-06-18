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

    MaterialTheme {
        Surface( modifier = Modifier.fillMaxSize() ) {
            Column() {
                TextField(
                    value = inputText,
                    onValueChange = { inputText = it },
                    label = { Text("Coloque a temperatura") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}