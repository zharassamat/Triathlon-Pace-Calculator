package sj.alashalemi.triathlonpacecalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import sj.alashalemi.triathlonpacecalculator.ui.BottomNavItem
import sj.alashalemi.triathlonpacecalculator.ui.screens.bike.BikeScreen
import sj.alashalemi.triathlonpacecalculator.ui.screens.run.RunScreen
import sj.alashalemi.triathlonpacecalculator.ui.screens.settings.SettingsScreen
import sj.alashalemi.triathlonpacecalculator.ui.screens.swim.SwimScreen
import sj.alashalemi.triathlonpacecalculator.ui.theme.TriathlonPaceCalculatorTheme
import sj.alashalemi.triathlonpacecalculator.ui.screens.triathlon.TriathlonScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TriathlonPaceCalculatorTheme {
                MainScreenView()
            }
        }
    }
}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.Run.screen_route) {
        composable(BottomNavItem.Run.screen_route) {
            RunScreen()
        }
        composable(BottomNavItem.Swim.screen_route) {
            SwimScreen()
        }
        composable(BottomNavItem.Bike.screen_route) {
            BikeScreen()
        }
        composable(BottomNavItem.Triathlon.screen_route) {
            TriathlonScreen()
        }
        composable(BottomNavItem.Settings.screen_route) {
            SettingsScreen()
        }
    }
}

@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(
        BottomNavItem.Run,
        BottomNavItem.Swim,
        BottomNavItem.Bike,
        BottomNavItem.Triathlon,
        BottomNavItem.Settings
    )
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.teal_200),
        contentColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title,
                    fontSize = 9.sp) },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Black.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.screen_route,
                onClick = {
                    navController.navigate(item.screen_route) {

                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun MainScreenView(){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigation(navController = navController) }
    ) {

        NavigationGraph(navController = navController)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TriathlonPaceCalculatorTheme {
        MainScreenView()
    }
}