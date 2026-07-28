package com.manga.services.library

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.manga.models.Chapter
import com.manga.models.ChapterContent
import com.manga.models.Manga
import java.io.File

class LibraryServices {

    fun scanFolder (rootPath : String): List<Manga> {
        var isValidMangaPath = false
        val mangaList = mutableListOf<Manga>()
        val rootFolder = File(rootPath)
        val mangaFolders = rootFolder.listFiles() { file -> file.isDirectory }
        if (mangaFolders != null) {
            for(mangaFolder in mangaFolders) {
                println("Scanning Manga: $mangaFolder")
                val mangaCover = setLocalMangaCover(mangaFolder)
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
                                println("Found Chapter: $imageFiles")
                                ChapterContent.ImageFolder(imagePaths = imageFiles.map { file -> file.path })

                            }

                            // tobeimplemented

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
                    println(mangaCover)
                    val manga = Manga(mangaFolder.name, mangaCover, chapters)
                    mangaList.add(manga)
                }

                }
            }
        return mangaList
    }
    fun setLocalMangaCover(mangaFolder : File) : String? {
        val chapterFolders = mangaFolder.listFiles { file -> file.isDirectory }
        if (chapterFolders != null) {
            val firstChapter = chapterFolders[0].listFiles()
            if (firstChapter != null) {
                return firstChapter[0].path
            }
        }
        return null
    }

}