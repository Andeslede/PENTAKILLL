package com.andreslegarreta.pentakill


sealed class NavRoutes(val route: String) {
    object Home : NavRoutes("home")
    object Contacts : NavRoutes("contacts")
    object Favorites : NavRoutes("favorites")
    object Profile : NavRoutes("perfil")
    object Streams : NavRoutes("streams")
}