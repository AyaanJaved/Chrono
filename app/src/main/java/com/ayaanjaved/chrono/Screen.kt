package com.ayaanjaved.chrono

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import com.ayaanjaved.chrono.models.BottomNavItem

fun getBottomNavItemsList(): List<BottomNavItem> {
    val list = listOf(
        BottomNavItem("Home", Icons.Filled.Home, "home"),
        BottomNavItem("Pomodoro", Icons.Filled.Check, "Pomodoro"),
        BottomNavItem("Stats", Icons.Filled.Info, "stats")
    )

    return list
}
