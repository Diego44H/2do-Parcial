package com.maestrocorona.appferia

import android.os.Bundle
import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen(onNavigateToSecondActivity = {
                startActivity(Intent(this, Activity2::class.java))
            })
        }
    }
}

@Composable
fun MainScreen(onNavigateToSecondActivity: () -> Unit) {
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
            // Aquí pasamos una imagen diferente para cada card
            BusinessItem("Negocios de la Nave 1", R.drawable.logo_rest)
            BusinessItem("Negocios de la Nave 2", R.drawable.logo_nave2)
            BusinessItem("Negocios de la Nave 3", R.drawable.logo_nave3)
            BusinessItem("Atracciones y Conciertos", R.drawable.logo_conciertos)

            Button(
                onClick = onNavigateToSecondActivity,
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text("Fechas importantes")
            }
        }
    }
}

@Composable
fun BusinessItem(text: String, imageResId: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.purple_80)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = "Imagen del negocio",
                modifier = Modifier
                    .size(100.dp)
                    .padding(8.dp)
            )
            Text(
                text = text,
                fontSize = 18.sp,
                modifier = Modifier.padding(8.dp),
                style = TextStyle(
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = Bold,
                    color = colorResource(id = R.color.purple_40)
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMyApp() {
    MainScreen(onNavigateToSecondActivity = {})
}
