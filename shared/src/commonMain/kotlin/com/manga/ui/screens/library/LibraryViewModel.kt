package com.manga.ui.screens.library

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.manga.models.Manga
import com.manga.repositories.LibraryRepository
import kotlinx.coroutines.launch

class LibraryViewModel (
    private val libraryRepository: LibraryRepository,
) : ViewModel() {


    var mangaList by mutableStateOf<List<Manga>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    fun loadLibrary() {
        println("load from database")
    }

    fun addToLibrary() {
        viewModelScope.launch {
            isLoading = true
            val result = libraryRepository.scanFolder()
            if(result != null) {
                println("Scanning $result")
                mangaList = result
            }
            isLoading = false
            println("Done")
        }
    }

    fun rescanLibrary() {
        println("rescan library")
    }


}