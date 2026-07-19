package com.manga.ui.screens.library

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.manga.models.Manga
import com.manga.services.library.LibraryScanner

class LibraryViewModel {
    var mangaList by mutableStateOf<List<Manga>>(emptyList())
        private set
    private val scanner = LibraryScanner()
    fun loadLibrary(rootPath: String) {
        mangaList = scanner.scanFolder(rootPath)
    }
}