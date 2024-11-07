package com.myproject.mycomposedesign

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.myproject.mycomposedesign.components.NavigationDrawerComponent
import com.myproject.mycomposedesign.screen.DetailsScreen
import com.myproject.mycomposedesign.screen.GameScreen
import com.myproject.mycomposedesign.screen.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            NavigationDrawerComponent(
                drawerState = drawerState,
                navController = navController
            )
        }
    ) {

        NavHost(navController = navController, startDestination = "home") {
            composable("home") {
                DetailsScreen(
                    drawerState = drawerState,
                    scope = scope
                )
            }
            composable("profile") { HomeScreen() }
            composable("settings") { GameScreen() }
            composable("games") { GameScreen() }
        }
    }
}