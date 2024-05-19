package com.ayaanjaved.chrono

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun StatsScreen(navController: NavController) {
    Log.d("StatsScreen", "StatsScreen")
    Text(text = "Stats Screen")

}