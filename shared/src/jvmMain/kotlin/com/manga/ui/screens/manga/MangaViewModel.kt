package com.manga.ui.screens.manga

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.manga.models.Manga
import com.manga.models.Chapter
import com.manga.services.library.LibraryScanner

class MangaViewModel {
    var chapterList by mutableStateOf<List<Chapter>>(emptyList())
        private set

    var mangaName by mutableStateOf("")
        private set
    private val scanner = LibraryScanner()
    fun loadChapters(manga: Manga) {
        chapterList = manga.chapters
    }
    fun loadMangaDetails(manga: Manga) {
        mangaName = manga.mangaName

    }
}