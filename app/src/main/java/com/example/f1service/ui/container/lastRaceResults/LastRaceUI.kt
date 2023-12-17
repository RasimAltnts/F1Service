package com.example.f1service.ui.container.lastRaceResults

import android.annotation.SuppressLint
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.f1service.model.DLastRaceResult
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.*
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.f1service.constant.F1Team
import com.example.f1service.constant.F1Driver
import com.example.f1service.model.DF1LastRaceModel
import com.example.f1service.ui.theme.DarkColorPalette
import com.example.f1service.ui.theme.LightColorPalette


@SuppressLint("MutableCollectionMutableState")
@Composable
fun LastRaceUI(viewModel: LastRaceViewModel = hiltViewModel()) {

    val list = remember { mutableStateOf(DF1LastRaceModel())}
    val pilot= remember { mutableStateOf(ArrayList<DLastRaceResult> ()) }

    val data by viewModel.resultList.observeAsState()
    data?.let {
        list.value = it
        pilot.value = it.pilot!!
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
            text = "${list.value.session} Session ${list.value.round} Round",
            modifier = Modifier.padding(0.dp,10.dp,0.dp,0.dp),
            maxLines = 1
        )

        Text(
            text = "${list.value.circuitName} Result",
            modifier = Modifier.padding(0.dp,10.dp,0.dp,0.dp),
            maxLines = 1
        )

        LazyColumn(
            contentPadding = PaddingValues(0.dp,0.dp,0.dp,60.dp),
        ) {
            pilot.value.let {
                items(
                    items = it,
                    itemContent = {
                        Holder(item = it,
                            mF1Driver = viewModel.getF1Driver(),
                            mF1Cons = viewModel.getF1Team())
                    })
            }
        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Holder(
    item:DLastRaceResult,
    mF1Driver: F1Driver,
    mF1Cons: F1Team
) {

    Card(modifier = Modifier
        .fillMaxWidth()
        .height(90.dp)
        .background(Color.Transparent)
        .padding(10.dp),
        elevation = CardDefaults.cardElevation(
            2.dp
        )
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
                    .background(dividerColor())) {

                }

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp)
                    .offset(0.dp, 30.dp)
                    .background(dividerColor())) {

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
                text = "+${item.point}",
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
    constructorURL:String?
) {
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
fun dividerColor(): Color {
    when(isSystemInDarkTheme()) {
        true -> return DarkColorPalette.dividerColor
        false -> return LightColorPalette.dividerColor
    }
}

