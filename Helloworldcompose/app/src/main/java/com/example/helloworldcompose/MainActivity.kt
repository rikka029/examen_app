package com.example.helloworldcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.helloworldcompose.ui.theme.HelloWorldComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloApp()
        }
    }
}
@Preview
@Composable
fun HelloApp (){
    HelloWorldComposeTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Greeting(
                name = "Android",
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview
@Composable
fun ExampleModifier() {
    Text(text = "Chuunibyou", modifier = Modifier.padding(horizontal = 16.dp))
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HelloWorldComposeTheme {
        Greeting("Rikka029")
    }

}

@Preview(showBackground = true, name = "Texto de prueba")
@Composable
fun secondPreview() {
    HelloWorldComposeTheme {
        Greeting("Rikka029")
    }
}