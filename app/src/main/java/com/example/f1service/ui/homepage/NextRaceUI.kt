package com.example.f1service.ui.homepage

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.f1service.counter.DCounter
import com.example.f1service.counter.INextRaceCounter
import com.example.f1service.counter.NextRaceCounter
import com.example.f1service.extension.time
import com.example.f1service.model.model.DNextRaceModel
import com.example.f1service.ui.theme.LightColorPalette
import java.time.ZonedDateTime
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NextRaceUI(
    value: DNextRaceModel,
    counter: NextRaceCounter
) {
    var day = remember{ mutableStateOf("0") }
    var hours = remember{ mutableStateOf("0") }
    var minutes = remember{ mutableStateOf("0") }
    var seconds = remember{ mutableStateOf("0") }

    val iNextRaceCounter = object : INextRaceCounter {
        override fun counter(counter: DCounter) {
            day.value = counter.days
            hours.value = counter.hours
            minutes.value = counter.minutes
            seconds.value = counter.seconds
        }
    }

    counter.setListener(listener = iNextRaceCounter)
    counter.startTimer(encodeRaceTime(value))

    Card(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(10.dp)
        .background(Color.Transparent),
        elevation = CardDefaults.cardElevation(
            5.dp
        ),
        border = BorderStroke(0.3.dp, brush = Brush.linearGradient(
            colors = listOf(
                Color.White,
                Color.Black,
            ),
            tileMode = TileMode.Mirror
        ))
    ) {
        Column(verticalArrangement = Arrangement.Top
            ,modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            LightColorPalette.nextRaceGradientEnd,
                            LightColorPalette.nextRaceGradientStart,
                        ),
                        radius = 3000f,
                        center = Offset.Infinite
                    )
                )) {
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(Alignment.Top)
                    .padding(10.dp)) {

                    Text(text = "F1 Service",
                        color = Color.White,
                        fontSize = 30.sp,
                        fontFamily = FontFamily.Serif)
                }

            Box(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.Transparent),
                contentAlignment = Alignment.CenterStart) {

                Row(verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(10.dp, 10.dp, 10.dp, 10.dp)
                        .wrapContentWidth(Alignment.Start)
                        .wrapContentHeight(Alignment.Top)
                        .border(0.3.dp, brush = Brush.linearGradient(
                                colors = listOf(
                                    Color.White,
                                    Color.Black,
                                ),
                                tileMode = TileMode.Mirror
                            ),
                            RoundedCornerShape(10)
                        ),

                ) {
                    CountDownTimerUI(title = "Days",day.value)
                    CountDownTimerUI(title = "Hours",hours.value)
                    CountDownTimerUI(title = "Minutes",minutes.value)
                    CountDownTimerUI(title = "Seconds",seconds.value)

                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(10.dp, 0.dp, 5.dp, 0.dp)
                        .background(Color.Transparent)) {

                        Text(text = value.nextRaceCircuitName, maxLines = 1)
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = "${value.nextRaceCity}, ${value.nextRaceCountry}", maxLines = 1)
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = value.nextRaceDate)

                    }
                }
            }
        }
    }
}

@Composable private fun CountDownTimerUI(
    title: String,value: String
) {
    Column(modifier = Modifier.padding(0.dp,10.dp,0.dp,0.dp)) {
        NextRaceTitle(title = title)
        Box(modifier = Modifier
            .fillMaxHeight()
            .width(50.dp)
            .background(Color.Transparent),
            contentAlignment = Alignment.Center ) {

            Text(text = value,
                fontFamily = FontFamily.Serif,
                fontSize = 20.sp,
                color = Color.White
            )
        }
    }
}


@Composable
private fun NextRaceTitle(title: String) {
    Box(modifier = Modifier
        .wrapContentHeight(Alignment.Top)
        .width(50.dp)
        .background(Color.Transparent),
        contentAlignment = Alignment.Center ) {

        Text(text = title,
            fontFamily = FontFamily.Serif,
            fontSize = 10.sp,
            color = Color.White
        )
    }
}

private fun encodeRaceTime(model:DNextRaceModel): Date {
    return ZonedDateTime.now().time(model.nextRaceDate,model.nextRaceTime)
}

