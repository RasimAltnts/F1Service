package com.example.f1service.ui.navigation

import com.example.f1service.R

sealed class BottomNavItem(var title:String,var icon:Int, var route:String) {
    object Home: BottomNavItem("Home", R.drawable.home,"Home")
    object Constructor: BottomNavItem("Constructor",R.drawable.f1_car_icon,"Constructor")
    object RaceList: BottomNavItem("Racelist",R.drawable.race_flag,"Racelist")
    object Driver: BottomNavItem("Driver",R.drawable.helmet,"Driver")
}
