package com.manga.services.library

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.manga.models.Chapter
import com.manga.models.ChapterContent
import com.manga.models.Manga
import java.io.File

class LibraryServices {

    var folderPath by mutableStateOf<String>("")
        private set

    fun scanFolder (rootPath : String): List<Manga> {
        var isValidMangaPath = false
        val mangaList = mutableListOf<Manga>()
        val rootFolder = File(rootPath)
        val mangaFolders = rootFolder.listFiles() { file -> file.isDirectory }
        if (mangaFolders != null) {
            for(mangaFolder in mangaFolders) {
                val chapters = mutableListOf<Chapter>()
                val chapterFolders = mangaFolder.listFiles { file -> file.isDirectory }
                if (chapterFolders != null) {
                    for (chapterFolder in chapterFolders) {

                        val files = chapterFolder.listFiles() ?: emptyArray<File>()
                        val pdfFiles = files.find {file ->file.name.endsWith(".pdf")}
                        val cbzFiles = files.find {file -> file.name.endsWith(".cbz")}
                        val imageFiles = files.filter {file -> file.name.endsWith(".png") || file.name.endsWith(".jpg") || file.name.endsWith(".jpeg") || file.name.endsWith(".webp") }

                        val content: ChapterContent = when {
                            imageFiles.isNotEmpty() -> {
                                isValidMangaPath = true
                                ChapterContent.ImageFolder(imagePaths = imageFiles.map { file -> file.path })
                            }

                            pdfFiles != null ->
                                ChapterContent.ImageFolder(null)
                            cbzFiles  != null ->
                                ChapterContent.ImageFolder(null)
                            else ->
                                ChapterContent.ImageFolder(null)
                        }
                        if (isValidMangaPath) {
                            val chapter = Chapter(chapterFolder.name, content)
                            chapters.add(chapter)
                        }
                        }


                    }

                if (isValidMangaPath) {
                    val manga = Manga(mangaFolder.name, chapters)
                    mangaList.add(manga)
                }

                }


            }

        return mangaList
    }

}