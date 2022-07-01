package sj.alashalemi.triathlonpacecalculator.ui

import sj.alashalemi.triathlonpacecalculator.R

sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String){

    object Home : BottomNavItem("Home", R.drawable.ic_run_24,"run")
    object MyNetwork: BottomNavItem("My Network",R.drawable.ic_run_24,"swim")
    object AddPost: BottomNavItem("Post",R.drawable.ic_run_24,"bike")
    object Notification: BottomNavItem("Notification",R.drawable.ic_run_24,"triathlon")
    object Jobs: BottomNavItem("Jobs",R.drawable.ic_run_24,"settings")
}