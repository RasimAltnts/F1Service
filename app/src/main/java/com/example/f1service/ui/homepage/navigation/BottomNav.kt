package com.example.f1service.ui.homepage.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun BottomNav(navController: NavController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Driver,
        BottomNavItem.Constructor
    )
}