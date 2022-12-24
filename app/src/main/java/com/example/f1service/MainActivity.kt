package com.example.f1service

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.f1service.counter.NextRaceCounter
import com.example.f1service.ui.container.Container
import com.example.f1service.ui.nextRace.NextRaceUI
import com.example.f1service.ui.nextRace.NextRaceViewModel
import com.example.f1service.ui.theme.F1ServiceComposeTheme
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.app
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel by viewModels<NextRaceViewModel>()

        val fireStoreDatabase = FirebaseFirestore.getInstance()
        fireStoreDatabase.collection("DriverImageURL")
            .get()
            .addOnSuccessListener {
                it.forEach { document ->
                    val doc = document.id
                    println("::${doc}")
                    println("::${document.get("maxVerstappen")}")
                }
            }


        setContent {
            F1ServiceComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .padding(5.dp)) {

                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.25f)
                            .background(
                                Color.Transparent
                            )
                            .shadow(
                                5.dp,
                                shape = RoundedCornerShape(2.dp),
                                clip = true,
                                ambientColor = Color.Black,
                                spotColor = Color.Black
                            )
                        ) {
                            NextRaceUI(viewModels =viewModel, counter = NextRaceCounter(), lifecycle = this@MainActivity )
                        }

                        Spacer(modifier = Modifier
                            .fillMaxWidth()
                            .height(10.dp))

                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .background(
                                Color.Transparent
                            )
                        ) {
                            Container()
                        }
                    }
                }
            }
        }
    }
}
