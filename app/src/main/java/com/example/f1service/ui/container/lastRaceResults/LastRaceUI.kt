package com.example.f1service.ui.container.lastRaceResults

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
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
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.f1service.constant.F1Team
import com.example.f1service.constant.F1Driver



@SuppressLint("MutableCollectionMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LastRaceUI(viewModel: LastRaceViewModel = hiltViewModel()) {

    val mF1Driver = F1Driver()
    val mF1Cons = F1Team()

    val circuitId = remember { mutableStateOf("") }
    val circuitName = remember { mutableStateOf("") }
    val pilot= remember { mutableStateOf(ArrayList<DLastRaceResult> ()) }

    val data by viewModel.resultList.observeAsState()
    data?.let {
        circuitId.value = it.circuitId
        circuitName.value = it.circuitName
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
            text = circuitId.value,
            color = Color.White,
            modifier = Modifier.padding(0.dp,10.dp,0.dp,0.dp)
        )
        Text(
            text = circuitName.value,
            color = Color.White,
            modifier = Modifier.padding(0.dp,10.dp,0.dp,0.dp)
        )

        LazyColumn(
            contentPadding = PaddingValues(0.dp,0.dp,0.dp,60.dp),
        ) {
            pilot.value.let {
                items(
                    items = it,
                    itemContent = {
                        Holder(item = it,
                            mF1Driver = mF1Driver,
                            mF1Cons = mF1Cons)
                    })
            }
        }

    }

}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalGlideComposeApi::class)
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
        ),
        border = BorderStroke(0.3.dp, brush = Brush.linearGradient(
            colors = listOf(
                Color.White,
                Color.Black,
            ),
            tileMode = TileMode.Repeated
        ))
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
    driverURL:String,
    constructorURL:String) {
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


