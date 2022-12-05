package com.example.f1service.ui.container

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.f1service.navigation.BottomNav
import com.example.f1service.navigation.NavigationGraph

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Container() {

    val navController = rememberNavController()

    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {

        Box(modifier = Modifier
            .fillMaxHeight(1f)
            .fillMaxWidth()
            .shadow(
                2.dp,
                shape = RoundedCornerShape(1.dp),
                clip = false,
                ambientColor = Color.Black,
                spotColor = Color.Black
            )) {

            Scaffold(
                modifier = Modifier.fillMaxHeight(1f),
                bottomBar = { BottomNav(navController = navController) }
            ) {
                NavigationGraph(navController = navController)
            }

        }
    }
}