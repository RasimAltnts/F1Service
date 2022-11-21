package com.example.f1service.ui.homepage.navigation

import com.example.f1service.R
import java.util.*

sealed class BottomNavItem(var title:String,var icon:Int, var route:String) {
    object Home:BottomNavItem("Home", R.drawable.home,"Home")
    object Driver:BottomNavItem("Driver",R.drawable.home,"Driver")
    object Constructor:BottomNavItem("Constructor",R.drawable.home,"Constructor")
}
