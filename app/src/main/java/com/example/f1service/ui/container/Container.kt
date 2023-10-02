package com.example.f1service.ui.container

import android.annotation.SuppressLint
import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.f1service.ui.navigation.BottomNav
import com.example.f1service.ui.navigation.NavigationGraph
import com.example.f1service.ui.nextRace.nextRaceUIBgEnd
import com.example.f1service.ui.nextRace.nextRaceUIBgStart

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Container() {

    val color = listOf(
        nextRaceUIBgEnd(),
        nextRaceUIBgStart()
    )

    val inlineTransaction = rememberInfiniteTransition()
    val offset by inlineTransaction.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 2000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    val brush = remember(offset) {
        object : ShaderBrush() {
            override fun createShader(size: Size): Shader {
                val widthOffset = size.width * offset
                val heightOffset = size.height * offset
                return LinearGradientShader(
                    colors = color,
                    from = Offset(widthOffset,heightOffset),
                    to = Offset(widthOffset + size.width,heightOffset + size.height),
                    tileMode = TileMode.Mirror
                )
            }
        }
    }

    val navController = rememberNavController()

    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .clip(RoundedCornerShape(15.dp))
        .border(BorderStroke(1.dp,brush=brush),
            RoundedCornerShape(15.dp))) {

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