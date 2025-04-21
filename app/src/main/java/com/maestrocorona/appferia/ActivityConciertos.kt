package com.maestrocorona.appferia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextAlign


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
    // Pantalla secundaria con texto y una imagen
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
            // Texto largo tipo Lorem Ipsum
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                        "Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                        "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center
            )

            // Imagen del artista
            androidx.compose.foundation.Image(
                painter = painterResource(id = R.drawable.artista),
                contentDescription = "Imagen del artista",
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
            )

            // Nombre del artista
            Text(
                text = "Los Ángeles Azules\n09 de mayo",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            // Botón para volver
            Button(
                onClick = onBackPressed,
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text("Regresar")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewConciertos() {
    Conciertos(onBackPressed = {/* Acción de navegación */})
}
