package com.ayaanjaved.chrono

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun PomodoroScreen(navController: NavController) {
    Log.d("PomodoroScreen", "PomodoroScreen called")
    Text(text = "Pomodoro Screen")
}