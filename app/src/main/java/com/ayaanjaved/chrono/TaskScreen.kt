package com.ayaanjaved.chrono

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun TaskScreen(navController: NavController) {
    Log.d("TaskScreen", "TaskScreen")
    Text(text = "TaskScreen")
}