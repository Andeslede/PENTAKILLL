package com.andreslegarreta.pentakill

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.andreslegarreta.pentakill.ui.theme.PentakillTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavHostController
import com.andreslegarreta.pentakill.screens.Home
import com.andreslegarreta.pentakill.screens.Contacts
import com.andreslegarreta.pentakill.screens.Favorites
import com.andreslegarreta.pentakill.screens.Profile
import com.andreslegarreta.pentakill.screens.Streams
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.NavGraph.Companion.findStartDestination


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PentakillTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {

    val navController = rememberNavController()

    Scaffold(
        topBar = { TopAppBar(title = {Text("PENTAKILL.GG")})  },
        content = { NavigationHost(navController = navController) },
        bottomBar = { BottomNavigationBar(navController = navController)}

    )
}


@Composable
fun NavigationHost(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = NavRoutes.Home.route,
    ) {
        composable(NavRoutes.Home.route) {
            Home()
        }

        composable(NavRoutes.Contacts.route) {
            Contacts()
        }

        composable(NavRoutes.Favorites.route) {
            Favorites()
        }

        composable(NavRoutes.Profile.route) {
            Profile()
        }

        composable(NavRoutes.Streams.route) {
            Streams()
        }
    }
}
@Composable
fun BottomNavigationBar(navController: NavHostController) {

    BottomNavigation {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route

        NavBarItems.BarItems.forEach { navItem ->

            BottomNavigationItem(
                selected = currentRoute == navItem.route,
                onClick = {
                    navController.navigate(navItem.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },

                icon = {
                    Icon(imageVector = navItem.image,
                        contentDescription = navItem.title)
                },
                label = {
                    Text(text = navItem.title)
                },
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PentakillTheme {
        MainScreen()
    }
}