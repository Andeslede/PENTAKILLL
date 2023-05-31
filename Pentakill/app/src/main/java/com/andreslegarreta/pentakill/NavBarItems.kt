package com.andreslegarreta.pentakill

import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.*

object NavBarItems {
    val BarItems = listOf(
        BarItem(
            title = "Menu",
            image = Icons.Filled.Menu,
            route = "home"
        ),
        BarItem(
            title = "Home",
            image = Icons.Filled.Home,
            route = "contacts"

        ),
        BarItem(
            title = "Streams",
            image = Icons.Filled.Videocam,
            route = "streams"

        ),
        BarItem(
            title = "Social",
            image = Icons.Filled.Chat,
            route = "favorites"
        ),
        BarItem(
            title = "Perfil",
            image = Icons.Filled.Person,
            route = "perfil"
        )

    )
}
