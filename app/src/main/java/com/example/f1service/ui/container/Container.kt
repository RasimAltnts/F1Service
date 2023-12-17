package com.example.f1service.ui.container

import android.annotation.SuppressLint
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.f1service.ui.navigation.BottomNav
import com.example.f1service.ui.navigation.NavigationGraph

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Container() {

    val navController = rememberNavController()

    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .clip(RoundedCornerShape(15.dp))) {
        Box(modifier = Modifier
            .fillMaxHeight(1f)
            .fillMaxWidth()) {

            Scaffold(
                modifier = Modifier.fillMaxHeight(1f),
                bottomBar = { BottomNav(navController = navController) }
            ) {
                NavigationGraph(navController = navController)
            }

        }
    }
}