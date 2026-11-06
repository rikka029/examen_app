package com.example.examen_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import android.content.Intent
import android.net.Uri
import android.webkit.WebView
import androidx.compose.material3.TextButton
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.foundation.Canvas
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.StrokeCap
import android.webkit.WebViewClient
import kotlinx.coroutines.launch
import com.example.examen_app.ui.theme.Examen_appTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Examen_appTheme {
                val snackbarHostState = remember { SnackbarHostState() }
                val scope = rememberCoroutineScope()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    snackbarHost = {
                        SnackbarHost(hostState = snackbarHostState)
                    },
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = {
                                scope.launch {
                                    snackbarHostState.showSnackbar(
                                        "Gracias por visitar mi perfil"
                                    )
                                }
                            },
                            containerColor = Color(0xFF7B2CBF),
                            contentColor = Color.White
                        ) {
                            Text("+")
                        }
                    }
                ) { innerPadding ->
                    Greeting(
                        name = "Brian Jael Juarez Rodriguez",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val contexto = LocalContext.current
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF120F1C))
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(230.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.portada),
                contentDescription = "Portada",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Image(
                painter = painterResource(id = R.drawable.foto_perfil),
                contentDescription = "Foto de perfil",
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .offset(x = 24.dp, y = 58.dp)
                    .size(118.dp)
                    .clip(CircleShape)
                    .border(4.dp, Color(0xFFD8B4FE), CircleShape),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(68.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF271B3A)
            ),
            shape = RoundedCornerShape(24.dp)
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = " PERFIL ",
                    color = Color(0xFFD8B4FE),
                    style = MaterialTheme.typography.labelLarge
                )
                Text(
                    text = name,
                    color = Color.White,
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    text = "brianjrz@micorreo.upp.edu.mx",
                    color = Color(0xFFE9D5FF)
                )
            }
        }

        Text(
            text = "Acerca de mí",
            modifier = Modifier.padding(start = 20.dp, top = 24.dp, end = 20.dp),
            color = Color(0xFFD8B4FE),
            style = MaterialTheme.typography.titleLarge
        )

        Text(
            text = "Soy un estudiante de TIID. Me gusta la programación y la tecnología. " +
                    "Me gusta aprender cosas nuevas, desarrollar proyectos y paso el tiempo " +
                    "con el anime, manga, juegos y la música. Me considero una persona curiosa, " +
                    "un poco creativa y perseverante.",
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 12.dp),
            color = Color(0xFFF4F0FA),
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = " LENGUAJES Y TECNOLOGÍAS ",
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 8.dp),
            color = Color(0xFFD8B4FE),
            style = MaterialTheme.typography.titleMedium
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            listOf(
                "Kotlin", "Java", "C++", "C#", "Python",
                "Android", "Jetpack Compose", "HTML", "CSS", "SQL"
            ).forEach { tecnologia ->
                Surface(
                    color = Color(0xFF392552),
                    shape = RoundedCornerShape(50)
                ) {
                    Text(
                        text = tecnologia,
                        modifier = Modifier.padding(
                            horizontal = 16.dp,
                            vertical = 10.dp
                        ),
                        color = Color(0xFFE9D5FF),
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }
        }
        Text(
            text = " UBICACIÓN ",
            modifier = Modifier.padding(
                start = 20.dp,
                top = 24.dp,
                end = 20.dp
            ),
            color = Color(0xFFD8B4FE),
            style = MaterialTheme.typography.titleMedium
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            shape = RoundedCornerShape(24.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            ) {
                Canvas(modifier = Modifier.fillMaxSize()) {
                    drawRect(Color(0xFFF0EEE7))

                    drawRoundRect(
                        color = Color(0xFFD9EFD5),
                        topLeft = Offset(size.width * 0.54f, size.height * 0.18f),
                        size = Size(size.width * 0.36f, size.height * 0.42f),
                        cornerRadius = CornerRadius(18.dp.toPx())
                    )

                    drawLine(
                        color = Color.White,
                        start = Offset(0f, size.height * 0.36f),
                        end = Offset(size.width, size.height * 0.54f),
                        strokeWidth = 22.dp.toPx(),
                        cap = StrokeCap.Round
                    )

                    drawLine(
                        color = Color.White,
                        start = Offset(size.width * 0.32f, 0f),
                        end = Offset(size.width * 0.57f, size.height),
                        strokeWidth = 14.dp.toPx(),
                        cap = StrokeCap.Round
                    )

                    drawLine(
                        color = Color(0xFFFFD166),
                        start = Offset(0f, size.height * 0.94f),
                        end = Offset(size.width * 0.43f, 0f),
                        strokeWidth = 8.dp.toPx(),
                        cap = StrokeCap.Round
                    )
                }

                Text(
                    text = "Ex-Hacienda de Santa Bárbara",
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(12.dp),
                    color = Color(0xFF53645A),
                    style = MaterialTheme.typography.labelSmall
                )

                Text(
                    text = "📍",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .offset(x = 8.dp, y = (-16).dp)
                )

                Text(
                    text = "Universidad Politécnica\nde Pachuca (UPP)",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .offset(x = 58.dp, y = 22.dp),
                    color = Color(0xFFB3261E),
                    style = MaterialTheme.typography.labelLarge
                )

                Text(
                    text = "Mapa ilustrativo",
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(start = 12.dp, bottom = 10.dp),
                    color = Color(0xFF53645A),
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }

        TextButton(
            onClick = {
                val direccion = Uri.parse(
                    "https://www.google.com/maps/search/?api=1" +
                            "&query=Universidad%20Politécnica%20de%20Pachuca"
                )
                contexto.startActivity(
                    Intent(Intent.ACTION_VIEW, direccion)
                )
            },
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 20.dp)
        ) {
            Text(
                text = "Abrir en Google Maps",
                color = Color(0xFFD8B4FE)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Examen_appTheme {
        Greeting("Android")
    }
}