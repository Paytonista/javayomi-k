package com.manga

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.navigation.compose.rememberNavController
import com.manga.ui.screens.library.LibraryViewModel
import com.manga.ui.screens.manga.MangaViewModel
import com.manga.ui.screens.reader.ReaderViewModel
import com.manga.navigation.AppNavigation
import androidx.compose.material3.TextButton
import com.manga.repositories.LibraryRepository
import com.manga.services.filesystem.FolderServices
import com.manga.services.library.LibraryServices
import io.github.vinceglb.filekit.FileKit
import kotlinx.coroutines.launch

@Preview
@Composable
fun App() {

    FileKit.init(appId = "MyApplication")

    val navController = rememberNavController()

    val libraryRepository = remember { LibraryRepository(FolderServices(), LibraryServices()) }

    //viewmodels
    val libraryViewModel = remember { LibraryViewModel(libraryRepository) }
    val mangaViewModel = remember { MangaViewModel() }
    val readerViewModel = remember { ReaderViewModel() }

    //repositories


    //services


    val scope = rememberCoroutineScope()

    Row {
        AppNavigation(
            navController = navController,
            libraryView = libraryViewModel,
            mangaView = mangaViewModel,
            readerView = readerViewModel
        )

        TextButton(onClick = {
            scope.launch {
                libraryViewModel.addToLibrary()
            }
        }) {
            Text("Add to Library")
        }


    }
}



