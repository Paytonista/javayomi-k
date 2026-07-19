package com.manga

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.manga.ui.screens.library.LibraryViewModel
import com.manga.ui.screens.library.LibraryScreen


@Preview
@Composable
fun App() {


    val libraryViewModel = remember { LibraryViewModel() }
    LibraryScreen(
        viewModel = libraryViewModel,
        onMangaClick = { manga -> println("Clicked: ${manga.mangaName}") }
    )
}

