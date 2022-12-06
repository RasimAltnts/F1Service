package com.example.f1service.ui.container.raceList

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.f1service.constant.F1CircuitCountry
import com.example.f1service.model.F1CurrentSession

@SuppressLint("MutableCollectionMutableState")
@Composable
fun RaceListUI(viewModel: RaceCalendarViewModel = hiltViewModel()) {


    val circuitId = remember { mutableStateOf("") }
    val circuitName = remember { mutableStateOf("") }
    val currentSession = remember { mutableStateOf(ArrayList<F1CurrentSession> ()) }

    val data by viewModel.calendar.observeAsState()
    data?.let {
        circuitId.value = it.circuitId
        circuitName.value = it.circuitName
        currentSession.value = it.session

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
            currentSession.value.let {
                items(
                    items = it,
                    itemContent = {
                        Holder(item = it, mF1CircuitCountry = viewModel.getF1CircuitCountry())
                    })
            }
        }

    }

}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalGlideComposeApi::class)
@Composable
fun Holder(
    item: F1CurrentSession,
    mF1CircuitCountry: F1CircuitCountry,
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
            
            Row(
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .size(60.dp)
                    .offset(20.dp, 5.dp)) {

                mF1CircuitCountry.getLink(item.country)?.let {
                    CountryImageView(
                        it
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
                text = "${item.racename},${item.location}",
                maxLines = 1,
                color = Color.Black,
                fontSize = 18.sp)

            Spacer(modifier = Modifier.width(10.dp))
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
private fun CountryImageView(
    countryUrl:String) {
    Row(modifier = Modifier
        .width(60.dp)
        .height(60.dp)
        .background(Color.Transparent)
    ) {
        Row(modifier = Modifier
            .size(45.dp)
            .padding(1.dp)
            .clip(CircleShape)
            .border(0.3.dp, Color.Black, CircleShape),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            GlideImage(model = countryUrl,
                contentDescription = null)
        }
    }
}


