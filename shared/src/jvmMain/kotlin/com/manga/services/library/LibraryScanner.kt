package com.manga.services.library

import com.manga.models.Chapter
import com.manga.models.ChapterContent
import com.manga.models.Manga
import java.io.File

class LibraryScanner {
    fun scanFolder (rootPath : String): List<Manga> {
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
                        val content = if (pdfFiles != null) {
                            ChapterContent.PdfFile(pdfFiles.path)
                        } else {
                            val imagePaths = files
                                //Refactor
                                .filter { file -> file.name.endsWith(".png") || file.name.endsWith(".jpg") || file.name.endsWith(".jpeg") || file.name.endsWith(".webp") }
                                .map { file -> file.path }
                            ChapterContent.ImageFolder(imagePaths)
                        }
                        val chapter = Chapter(chapterFolder.name, content)
                        chapters.add(chapter)
                    }
                }
                val manga = Manga(mangaFolder.name, chapters)
                mangaList.add(manga)
            }
        }
        return mangaList
    }
}