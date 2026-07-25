package com.manga.ui.screens.reader

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.manga.models.Chapter
import com.manga.models.ChapterContent
import com.manga.models.Manga
import java.util.zip.ZipFile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ReaderViewModel : ViewModel() {
    var imageList by mutableStateOf<List<String>>(emptyList())
        private set
    var pdfPath by mutableStateOf<String>("")
        private set
    var cbzPath by mutableStateOf<String>("")
        private set

    var chapterIndex by mutableStateOf<Int>(0)
        private set

    var pageCount by mutableStateOf<Int>(0)
    private set

    var currentPage by mutableStateOf(0)
        private set


    var mangaName by mutableStateOf("")
        private set

    fun listCbzPages (filePath: String):List<String> {
        ZipFile(filePath).use { zip ->
            return zip.entries()
                .asSequence()
                .filter { !it.isDirectory && it.name.substringAfterLast('.').lowercase() in setOf("jpg", "jpeg", "png", "webp") }
                .map { it.name }
                .sorted()
                .toList()
        }
    }

    fun loadChapter(chapter: Chapter) {
        println("Loading chapter")
        chapterIndex = 0
        when(val content = chapter.content) {
            is ChapterContent.ImageFolder -> {
                println(chapter)
                println("Loading image chapter")
                imageList = content.imagePaths
                println(imageList)
                pageCount = content.imagePaths.size
                println(pageCount)

            }
            is ChapterContent.PdfFile -> {
                pdfPath = content.filePath

            }
            is ChapterContent.CbzFile -> {
                cbzPath = content.filePath
                viewModelScope.launch(Dispatchers.IO) {
                    val pages = listCbzPages(content.filePath)
                    withContext(Dispatchers.Main) {
                        imageList = pages
                        pageCount = pages.size

                    }
                }

            }
        }
    }



    fun loadSettings(manga: Manga) {
        mangaName = manga.mangaName
    }

    fun onNextClicked() {
        if(chapterIndex < pageCount - 1) {
            chapterIndex +=  1
            println(chapterIndex)

        }
    }

    fun onPrevClicked() {
        if(chapterIndex > 0) {
            chapterIndex -= 1
            println(chapterIndex)
        }
    }
}