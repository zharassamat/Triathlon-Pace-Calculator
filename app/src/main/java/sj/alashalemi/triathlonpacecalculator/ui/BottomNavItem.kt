package sj.alashalemi.triathlonpacecalculator.ui

import sj.alashalemi.triathlonpacecalculator.R

sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String){

    object Run : BottomNavItem("Run", R.drawable.ic_run_24,"run")
    object Swim: BottomNavItem("Swim",R.drawable.ic_run_24,"swim")
    object Bike: BottomNavItem("Bike",R.drawable.ic_run_24,"bike")
    object Triathlon: BottomNavItem("Triathlon",R.drawable.ic_run_24,"triathlon")
    object Settings: BottomNavItem("Settings",R.drawable.ic_run_24,"settings")
}