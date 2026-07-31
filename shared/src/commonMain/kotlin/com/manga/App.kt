package com.manga

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.navigation.compose.rememberNavController
import com.manga.ui.screens.library.LibraryViewModel
import com.manga.ui.screens.manga.MangaViewModel
import com.manga.ui.screens.reader.ReaderViewModel
import com.manga.navigation.AppNavigation
import androidx.compose.material3.TextButton
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.manga.repositories.LibraryRepository
import com.manga.services.filesystem.FolderServices
import com.manga.services.library.LibraryServices
import io.github.vinceglb.filekit.FileKit


@Preview
@Composable
fun App(navController: NavHostController = rememberNavController()) {

    FileKit.init(appId = "MyApplication")

    val libraryRepository = remember { LibraryRepository(FolderServices(), LibraryServices()) }

    //view models
    val libraryViewModel = remember { LibraryViewModel(libraryRepository) }
    val mangaViewModel = remember { MangaViewModel() }
    val readerViewModel = remember { ReaderViewModel() }

    //repositories


    Row {
        AppNavigation(
            navController = navController,
            libraryView = libraryViewModel,
            mangaView = mangaViewModel,
            readerView = readerViewModel
        )


    }
}



