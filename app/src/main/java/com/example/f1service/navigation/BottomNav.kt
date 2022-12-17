package com.example.f1service.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.f1service.ui.container.constructor.ConstructorUI
import com.example.f1service.ui.container.driver.DriverUI
import com.example.f1service.ui.container.lastRaceResults.LastRaceUI
import com.example.f1service.ui.container.raceList.RaceListUI

@Composable
fun BottomNav(navController:NavController) {

    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Driver,
        BottomNavItem.Constructor,
        BottomNavItem.RaceList
    )

    BottomNavigation(
        backgroundColor = Color.Black,
        contentColor = Color.White,
        modifier = Modifier
            .height(60.dp)
            .clip(RoundedCornerShape(topEnd = 10.dp, topStart = 10.dp))
    ) {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(painterResource(id = item.icon),
                        contentDescription = item.title,
                    modifier = Modifier.size(32.dp))},
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(item.route)
                        launchSingleTop = true
                        restoreState = true
                    }
                })
        }
    }
}


@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.Home.route) {
        composable(BottomNavItem.Home.route) {
            LastRaceUI()
        }
        composable(BottomNavItem.Driver.route) {
            DriverUI()
        }
        composable(BottomNavItem.Constructor.route) {
            ConstructorUI()
        }
        composable(BottomNavItem.RaceList.route) {
            RaceListUI()
        }
    }
}


