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
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
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
import com.example.f1service.ui.container.lastRaceResults.dividerColor

@SuppressLint("MutableCollectionMutableState")
@Composable
fun RaceListUI(viewModel: RaceListViewModel = hiltViewModel()) {

    val session = remember { mutableStateOf("") }
    val currentSession = remember { mutableStateOf(ArrayList<F1CurrentSession> ()) }

    val data by viewModel.calendar.observeAsState()
    data?.let {
        session.value = it.session[0].session
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
            text = "${session.value} Session Race Calendar",
            modifier = Modifier.padding(0.dp,10.dp,0.dp,0.dp)
        )

        LazyColumn(
            contentPadding = PaddingValues(0.dp,0.dp,0.dp,60.dp),
        ) {
            currentSession.value.let {
                items(
                    items = it,
                    itemContent = {
                        Holder(
                            item = it,
                            mF1CircuitCountry = viewModel.f1Circ
                        )
                    })
            }
        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Holder(
    item: F1CurrentSession,
    mF1CircuitCountry: F1CircuitCountry,
) {
    val expandedHeight = remember { mutableStateOf(90.dp) }

    Card(modifier = Modifier
        .fillMaxWidth()
        .height(expandedHeight.value)
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
        )),
        onClick = {
            if (!item.expanded) {
                expandedHeight.value = 180.dp
                item.expanded = true
            }
            else{
                expandedHeight.value = 90.dp
                item.expanded = false
            }
        }
    ) {
        if (item.expanded) {
            ExpandedCardViewUI(
                item = item,
                mF1CircuitCountry = mF1CircuitCountry
            )

        }
        else NotExpandedCardUI(
            item = item,
            mF1CircuitCountry = mF1CircuitCountry)
    }
}


@Composable
private fun NotExpandedCardUI(
    item:F1CurrentSession,
    mF1CircuitCountry: F1CircuitCountry
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(Color.White)
        .padding(10.dp, 0.dp),
        horizontalArrangement = Arrangement.Center)
    {

        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .size(60.dp)
                .offset(20.dp, 10.dp)) {

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

        Column(modifier = Modifier
            .padding(0.dp, 10.dp)
            .wrapContentHeight()
            .fillMaxWidth()
            .background(Color.Transparent)) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
                .background(Color.Transparent)) {

                Text(modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth(),
                    text = "${item.racename},${item.location}",
                    maxLines = 1,
                    color = Color.Black,
                    fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.height(5.dp))

            Row(modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
                .background(Color.Transparent)) {

                Text(modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth(),
                    text = "${item.date},${item.time},${item.location.country}",
                    maxLines = 1,
                    color = Color.Black,
                    fontSize = 12.sp)
            }
        }
    }
}


@Composable
private fun ExpandedCardViewUI(
    item:F1CurrentSession,
    mF1CircuitCountry: F1CircuitCountry
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(Color.White)
        .padding(10.dp, 0.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically)
    {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
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
            .width(2.dp)
            .background(Color.Transparent),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top ) {

            Row(modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .background(dividerColor())) {

            }

            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(Color.Transparent))

            Row(modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .background(dividerColor())) {

            }

        }

        Spacer(modifier = Modifier.width(20.dp))

        Column(modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(Color.Transparent)
            .padding(0.dp, 10.dp)) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(Color.Transparent)) {

                Text(modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth(),
                    text = "${item.racename},${item.location}",
                    maxLines = 1,
                    color = Color.Black,
                    fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.height(5.dp))

            Row(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.Transparent)) {

                Column(modifier = Modifier.fillMaxSize()) {
                    Text(modifier = Modifier
                        .wrapContentHeight()
                        .fillMaxWidth(),
                        text = "${item.date},${item.time},${item.location.country}",
                        maxLines = 1,
                        color = Color.Black,
                        fontSize = 12.sp)
                    
                    Spacer(modifier = Modifier
                        .fillMaxWidth()
                        .height(10.dp))

                    Text(modifier = Modifier
                        .wrapContentHeight()
                        .fillMaxWidth(),
                        text = "First Prac : ${item.firstPractice?.date},${item.firstPractice?.time}",
                        maxLines = 1,
                        color = Color.Black,
                        fontSize = 12.sp)

                    Spacer(modifier = Modifier
                        .fillMaxWidth()
                        .height(10.dp))

                    Text(modifier = Modifier
                        .wrapContentHeight()
                        .fillMaxWidth(),
                        text = "Sec Prac : ${item.secondPractice?.date},${item.secondPractice?.time}",
                        maxLines = 1,
                        color = Color.Black,
                        fontSize = 12.sp)

                    Spacer(modifier = Modifier
                        .fillMaxWidth()
                        .height(10.dp))

                    Text(modifier = Modifier
                        .wrapContentHeight()
                        .fillMaxWidth(),
                        text = "Third Prac : ${item.thirdPractice?.date},${item.thirdPractice?.time}",
                        maxLines = 1,
                        color = Color.Black,
                        fontSize = 12.sp)
                }
            }
        }
    }
}


@Composable
fun Divider() {
    Row(modifier = Modifier
        .fillMaxWidth(0.8f)
        .height(5.dp)
        .offset(20.dp, 5.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Start) {

        Box(modifier = Modifier
            .size(5.dp)
            .clip(CircleShape)
            .background(Color.Gray)) {

        }

        Box(modifier = Modifier
            .width(150.dp)
            .height(1.dp)
            .offset(0.dp, 2.dp)
            .padding(0.dp, 0.dp, 0.dp, 0.dp)
            .background(Color.Gray)) {

        }

        Box(modifier = Modifier
            .size(5.dp)
            .clip(CircleShape)
            .background(Color.Gray)) {

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


