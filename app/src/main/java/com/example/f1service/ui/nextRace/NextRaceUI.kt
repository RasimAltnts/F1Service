package com.example.f1service.ui.nextRace

import android.os.Build
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleOwner
import com.example.f1service.R
import com.example.f1service.counter.DCounter
import com.example.f1service.counter.INextRaceCounter
import com.example.f1service.counter.NextRaceCounter
import com.example.f1service.extension.time
import com.example.f1service.model.model.DNextRaceModel
import com.example.f1service.ui.theme.DarkColorPalette
import com.example.f1service.ui.theme.LightColorPalette
import java.time.ZonedDateTime
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NextRaceUI(
    counter: NextRaceCounter?,
    viewModels: NextRaceViewModel,
    lifecycle: LifecycleOwner
) {
    val day = remember { mutableStateOf("0") }
    val hours = remember { mutableStateOf("0") }
    val minutes = remember { mutableStateOf("0") }
    val seconds = remember { mutableStateOf("0") }

    val circuitName = remember { mutableStateOf("") }
    val nextRaceCity = remember { mutableStateOf("") }
    val nextRaceCountry = remember { mutableStateOf("") }
    val nextRaceDate = remember { mutableStateOf("") }

    val iNextRaceCounter = object : INextRaceCounter {
        override fun counter(counter: DCounter) {
            day.value = counter.days
            hours.value = counter.hours
            minutes.value = counter.minutes
            seconds.value = counter.seconds
        }
    }

    viewModels.nextRaceInfo.observe(lifecycle) {
        circuitName.value = it.nextRaceCircuitName.toString()
        nextRaceCity.value = it.nextRaceCity.toString()
        nextRaceCountry.value = it.nextRaceCountry.toString()
        nextRaceDate.value = it.nextRaceDate.toString()

        if (counter != null) {
            counter.setListener(iNextRaceCounter)
            encodeRaceTime(it)?.let { date ->
                counter.startTimer(date)
            }
        }
    }

    viewModels.sendRequest()

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .clip(RoundedCornerShape(5.dp)),
        shape = RoundedCornerShape(5.dp),
        elevation = CardDefaults.cardElevation(
            5.dp
        ),
        border = BorderStroke(
            0.3.dp,
            brush = Brush.linearGradient(
                colors = listOf(
                    Color.White,
                    Color.Black,
                ),
                tileMode = TileMode.Mirror
            )
        )
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            nextRaceUIBgEnd(),
                            nextRaceUIBgStart()
                        ),
                        radius = 1000f,
                        center = Offset.Infinite
                    )
                )
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(Alignment.Top)
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                val img = painterResource(id = R.drawable.f1_car)

                Image(
                    modifier = Modifier
                        .width(100.dp)
                        .height(35.dp)
                        .scale(1.5f),
                    painter = img,
                    contentDescription = "null"
                )

                Spacer(modifier = Modifier.width(5.dp))

                Text(
                    modifier = Modifier
                        .wrapContentHeight(Alignment.Top)
                        .wrapContentWidth(Alignment.Start)
                        .padding(10.dp),
                    text = "F1 Service",
                    color = textColor(),
                    fontSize = 30.sp,
                    fontFamily = FontFamily.Serif
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(Color.Transparent),
                contentAlignment = Alignment.CenterStart
            ) {

                Row(
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(10.dp, 10.dp, 10.dp, 10.dp)
                        .wrapContentWidth(Alignment.Start)
                        .wrapContentHeight(Alignment.Top)
                ) {
                    CountDownTimerUI(title = "Days", day.value)
                    CountDownTimerUI(title = "Hours", hours.value)
                    CountDownTimerUI(title = "Minutes", minutes.value)
                    CountDownTimerUI(title = "Seconds", seconds.value)

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(10.dp, 0.dp, 5.dp, 0.dp)
                            .background(Color.Transparent)
                    ) {

                        Text(text = circuitName.value, maxLines = 1, color = textColor())
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = "${nextRaceCity.value}, ${nextRaceCountry.value }", maxLines = 1, color = textColor())
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = nextRaceDate.value, color = textColor())
                    }
                }
            }
        }
    }
}

@Composable private fun CountDownTimerUI(
    title: String,
    value: String
) {
    Column(modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp)) {
        NextRaceTitle(title = title)
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(50.dp)
                .background(Color.Transparent),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = value,
                fontFamily = FontFamily.Serif,
                fontSize = 20.sp,
                color = textColor()
            )
        }
    }
}

@Composable
private fun NextRaceTitle(title: String) {
    Box(
        modifier = Modifier
            .wrapContentHeight(Alignment.Top)
            .width(50.dp)
            .background(Color.Transparent),
        contentAlignment = Alignment.Center
    ) {

        Text(
            text = title,
            fontFamily = FontFamily.Serif,
            fontSize = 10.sp,
            color = textColor()
        )
    }
}

fun encodeRaceTime(model: DNextRaceModel): Date? {
    var date: Date ? = null
    if (model.nextRaceDate != null && model.nextRaceTime != null) {
        date = ZonedDateTime.now().time(model.nextRaceDate!!, model.nextRaceTime!!)
    }
    return date
}

@Composable
private fun textColor(): Color {
    if (isSystemInDarkTheme()) {
        return DarkColorPalette.textColor
    } else {
        return LightColorPalette.textColor
    }
}

@Composable
fun nextRaceUIBgStart(): Color {
    // Use Dynamic Color
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        when (isSystemInDarkTheme()) {
            true -> return dynamicDarkColorScheme(LocalContext.current).primary
            false -> return dynamicLightColorScheme(LocalContext.current).primary
        }
    } else {
        when (isSystemInDarkTheme()) {
            true -> return DarkColorPalette.nextRaceGradientStart
            false -> return LightColorPalette.nextRaceGradientStart
        }
    }
}

@Composable
fun nextRaceUIBgEnd(): Color {
    when (isSystemInDarkTheme()) {
        true -> return DarkColorPalette.nextRaceGradientEnd
        false -> return LightColorPalette.nextRaceGradientEnd
    }
}
