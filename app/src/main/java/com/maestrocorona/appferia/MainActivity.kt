package com.maestrocorona.appferia

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen(
                onNavigateNave1 = { startActivity(Intent(this, ActivityNave1::class.java)) },
                onNavigateNave2 = { startActivity(Intent(this, ActivityNave2::class.java)) },
                onNavigateNave3 = { startActivity(Intent(this, ActivityNave3::class.java)) },
                onNavigateConciertos = { startActivity(Intent(this, ActivityConciertos::class.java)) },
                onNavigateToSecondActivity = { startActivity(Intent(this, Activity2::class.java)) }
            )
        }
    }
}

@Composable
fun MainScreen(
    onNavigateNave1: () -> Unit,
    onNavigateNave2: () -> Unit,
    onNavigateNave3: () -> Unit,
    onNavigateConciertos: () -> Unit,
    onNavigateToSecondActivity: () -> Unit
) {
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
            BusinessItem("Atracciones y juegos", R.drawable.logo_nave1, onNavigateNave1)
            BusinessItem("Alimentos y bebidas", R.drawable.logo_nave2, onNavigateNave2)
            BusinessItem("Artesanias y ventas", R.drawable.logo_nave3, onNavigateNave3)
            BusinessItem("Artistas principales", R.drawable.logo_rest, onNavigateConciertos)

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
fun BusinessItem(text: String, imageResId: Int, onButtonClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.purple_80)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = "Imagen del negocio",
                modifier = Modifier
                    .size(130.dp)
                    .padding(8.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(8.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = text,
                    fontSize = 18.sp,
                    style = TextStyle(
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = Bold,
                        color = colorResource(id = R.color.purple_40)
                    )
                )
                Button(
                    onClick = onButtonClick,
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    Text("Ver más")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMyApp() {
    MainScreen(
        onNavigateNave1 = {},
        onNavigateNave2 = {},
        onNavigateNave3 = {},
        onNavigateConciertos = {},
        onNavigateToSecondActivity = {}
    )
}
