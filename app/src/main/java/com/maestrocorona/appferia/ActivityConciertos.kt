package com.maestrocorona.appferia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// ActivityNave1.kt
class ActivityConciertos : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Conciertos(onBackPressed = { finish() })
        }
    }
}

@Composable
fun Conciertos(onBackPressed: () -> Unit) {
    // Pantalla secundaria con lista de conciertos
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Lista de conciertos
            Text("Concierto de Rock")
            Text("Concierto de Jazz")
            Text("Concierto de Música Electrónica")

            // Botón para volver
            Button(
                onClick = onBackPressed,
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text("Ver detalles del concierto")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewConciertos() {
    Conciertos(onBackPressed = {/* Acción de navegación */})
}
