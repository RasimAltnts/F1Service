package com.example.f1service.ui.container.driver

import android.annotation.SuppressLint
import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.f1service.constant.F1Driver
import com.example.f1service.constant.F1Team
import com.example.f1service.model.DF1DriversModels
import com.example.f1service.model.F1DriverModels
import com.example.f1service.ui.nextRace.nextRaceUIBgEnd
import com.example.f1service.ui.nextRace.nextRaceUIBgStart
import com.example.f1service.ui.theme.DarkColorPalette
import com.example.f1service.ui.theme.LightColorPalette

@SuppressLint("MutableCollectionMutableState")
@Composable
fun DriverUI(viewModel: DriverViewModel = hiltViewModel()) {

    val list = remember { (mutableStateOf(DF1DriversModels())) }
    val result = remember { mutableStateOf(ArrayList<F1DriverModels> ()) }

    val data by viewModel.result.observeAsState()
    data?.let {
        list.value = it
        it.list?.let { result.value = it }
    }



    viewModel.sendRequest()

    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(Color.Transparent),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text(
            text = "${list.value.session} Session ${list.value.round} Round Driver Standlist",
            color = textColor(),
            modifier = Modifier.padding(0.dp,10.dp,0.dp,0.dp)
        )
        LazyColumn(
            contentPadding = PaddingValues(0.dp,0.dp,0.dp,60.dp),
        ) {
            result.value.let {
                items(
                    items = it,
                    itemContent = {
                        Holder(item = it,
                            mF1Driver = viewModel.f1Driver,
                            mF1Cons = viewModel.getConsImage())
                    })
            }
        }

    }
}


@OptIn(ExperimentalMaterial3Api::class, ExperimentalGlideComposeApi::class)
@Composable
fun Holder(
    item: F1DriverModels,
    mF1Driver: F1Driver,
    mF1Cons: F1Team
) {

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

    Card(modifier = Modifier
        .fillMaxWidth()
        .height(90.dp)
        .background(Color.Transparent)
        .padding(10.dp),
        elevation = CardDefaults.cardElevation(
            2.dp
        ),
        border = BorderStroke(1.25.dp, brush = brush)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(Color.White),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically)
        {

            Row(modifier = Modifier
                .size(30.dp)
                .offset(20.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = item.position,
                    color = Color.Black,
                    fontSize = 18.sp)
            }

            Row(
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .size(60.dp)
                    .offset(20.dp, 5.dp)) {

                mF1Driver.getLink(item.pilotName)?.let {
                    DriverImageView(
                        it,
                        mF1Cons.getLink(item.constructorId)
                    )
                }
            }

            Spacer(modifier = Modifier.width(20.dp))


            Column(modifier = Modifier
                .fillMaxHeight()
                .width(2.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top) {

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp)
                    .background(Color.Gray)) {

                }

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp)
                    .offset(0.dp, 20.dp)
                    .background(Color.Gray)) {

                }
            }

            Spacer(modifier = Modifier.width(20.dp))

            Text(modifier = Modifier
                .wrapContentHeight()
                .width(150.dp),
                text = "${item.pilotName} ${item.pilotSurname}",
                maxLines = 1,
                color = Color.Black,
                fontSize = 18.sp)

            Spacer(modifier = Modifier.width(10.dp))

            Text(modifier = Modifier
                .wrapContentHeight()
                .width(50.dp),
                text = "${item.points} P",
                maxLines = 1,
                color = Color.Black,
                fontSize = 18.sp)
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
private fun DriverImageView(
    driverURL:String?,
    constructorURL:String?) {
    Row(modifier = Modifier
        .width(60.dp)
        .height(60.dp)
        .background(Color.White)
    ) {
        Row(modifier = Modifier
            .size(45.dp)
            .padding(1.dp)
            .clip(CircleShape)
            .border(0.3.dp, Color.Black, CircleShape),
            horizontalArrangement = Arrangement.Start,
        ) {
            GlideImage(model = driverURL,
                contentDescription = null)
        }

        Row(modifier = Modifier
            .offset((-20).dp, 35.dp)
            .size(30.dp)
            .background(Color.Transparent)
            .clip(CircleShape)) {
            GlideImage(model = constructorURL,
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape),
                alignment = Alignment.TopStart,
                contentDescription = null)
        }
    }
}

@Composable
private fun textColor(): Color {
    if (isSystemInDarkTheme()) {
        return DarkColorPalette.textColor
    }
    else {
        return LightColorPalette.textColor
    }
}