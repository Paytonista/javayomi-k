package com.manga

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Row
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.manga.models.Screens
import com.manga.ui.screens.library.LibraryViewModel
import com.manga.ui.screens.library.MangaViewModel
import com.manga.ui.screens.library.LibraryScreen
import com.manga.ui.screens.library.MangaScreen
import androidx.navigation.toRoute
import com.manga.navigation.AppNavigation

@Preview
@Composable
fun App() {

    val navController = rememberNavController()
    val libraryViewModel = remember { LibraryViewModel() }
    val mangaViewModel = remember { MangaViewModel() }
    Row {
        AppNavigation(
            navController = navController,
            libraryView = libraryViewModel,
            mangaView = mangaViewModel
        )
    }
}



