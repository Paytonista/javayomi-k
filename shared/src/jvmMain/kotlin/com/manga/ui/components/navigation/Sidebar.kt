package com.manga.ui.components.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Web
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.manga.models.Screens
import androidx.compose.material3.Text


@Composable
fun Sidebar(navController: NavController) {
    NavigationRail {
        NavigationRailItem(
            selected = true,
            onClick = { navController.navigate(Screens.Library) },
            icon = { Icon(Icons.Default.Book, null) },
            label = { Text("Library") }
        )
        NavigationRailItem(
            selected = true,
            onClick = { navController.navigate(Screens.Library) },
            icon = { Icon(Icons.Default.Web, null) },
            label = { Text("Browse") }
        )
    }
}
