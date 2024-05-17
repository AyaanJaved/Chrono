package com.ayaanjaved.chrono

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ayaanjaved.chrono.ui.theme.ChronoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChronoTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                       NavigationBar {
                           // This can be optimised by storing a list Items and their icons. The data
                           // structure could be a simple list.

                           // Can also look into extracting this whole into its own composable

                           var selectedItem by remember { mutableIntStateOf(0) }

                           NavigationBarItem(
                               selected = selectedItem == 0,
                               onClick = {selectedItem = 0},
                               icon = { Icon(imageVector = Icons.Filled.Add, contentDescription = "")})

                           NavigationBarItem(
                               selected = selectedItem == 1,
                               onClick = {selectedItem = 1},
                               icon = { Icon(imageVector = Icons.Filled.Add, contentDescription = "")})

                           NavigationBarItem(
                               selected = selectedItem == 2,
                               onClick = {selectedItem = 2},
                               icon = { Icon(imageVector = Icons.Filled.Add, contentDescription = "")})
                       }
                    }
                ) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ChronoTheme {
        Greeting("Android")
    }
}