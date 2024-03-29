package com.example.f1service.ui.container.constructor

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
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
import com.example.f1service.constant.F1Team
import com.example.f1service.model.DF1ConstructorModel
import com.example.f1service.model.F1ConstructorModel
import com.example.f1service.ui.container.lastRaceResults.dividerColor

@SuppressLint("MutableCollectionMutableState")
@Composable
fun ConstructorUI(viewModel:ConstructorViewModel = hiltViewModel()) {

    val list = remember { (mutableStateOf(DF1ConstructorModel())) }
    val result = remember { mutableStateOf(ArrayList<F1ConstructorModel> ()) }


    val data by viewModel.results.observeAsState()
    data?.let {
        list.value = it
        it.list?.let { result.value = it }
    }

    viewModel.sendRequest()

    Column(modifier = Modifier
        .fillMaxSize(1f)
        .background(Color.Transparent),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(
            text = "${list.value.series} Session Constructor Results",
            modifier = Modifier.padding(0.dp,10.dp,0.dp,0.dp)
        )

        LazyColumn(
            contentPadding = PaddingValues(0.dp,0.dp,0.dp,60.dp),
        ) {
            result.value.let {
                items(
                    items = it,
                    itemContent = {
                        Holder(
                            item = it,
                            mF1Team = viewModel.f1Team
                        )
                    }
                )
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Holder(
    item: F1ConstructorModel,
    mF1Team: F1Team,
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
        CardViewUI(item = item, f1Team = mF1Team)
    }
}

@Composable
fun CardViewUI(
    item: F1ConstructorModel,
    f1Team: F1Team,
) {
    Row(modifier = Modifier
        .fillMaxHeight()
        .wrapContentWidth()
        .background(Color.White)
        .padding(10.dp, 0.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically) {

        Text(text = item.position.toString(),
            color = Color.Black,
            fontSize = 18.sp)

        Row(
            modifier = Modifier
                .size(60.dp)
                .offset(20.dp, 5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            item.consId?.let {
                ConstructorImageView(url = f1Team.getLink(it))
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
                .height(25.dp)
                .background(dividerColor())) {

            }

            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
                .background(Color.Transparent))

            Row(modifier = Modifier
                .fillMaxWidth()
                .height(25.dp)
                .background(dividerColor())) {

            }

        }

        Row(modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(0.6f)
            .background(Color.Transparent)) {
            Spacer(modifier = Modifier.width(0.dp))

            Text(text = item.name.toString(),
                color = Color.Black,
                fontSize = 18.sp,
                maxLines = 1,
                modifier = Modifier
                    .padding(20.dp, 20.dp, 0.dp, 0.dp)
                    .background(Color.Transparent))

        }

        Row(modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(1f)
            .background(Color.Transparent)) {
            Spacer(modifier = Modifier.width(0.dp))

            Text(text = "${item.points.toString()} P",
                color = Color.Black,
                fontSize = 18.sp,
                maxLines = 1,
                modifier = Modifier
                    .padding(20.dp, 20.dp, 0.dp, 0.dp)
                    .background(Color.Transparent))

        }
    }

}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
private fun ConstructorImageView(
    url:String?
) {
    Row(modifier = Modifier
        .width(60.dp)
        .height(60.dp)
        .background(Color.Transparent)
    ) {
        Row(modifier = Modifier
            .size(45.dp)
            .padding(1.dp)
            .clip(CircleShape),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            GlideImage(model = url,
                contentDescription = null)
        }
    }
}
