package com.manga.models

sealed class ChapterContent {
    data class ImageFolder(val imagePaths: List<String>) : ChapterContent()
    data class PdfFile(val filePath: String) : ChapterContent()
    data class CbzFile(val filePath: String) : ChapterContent()
}

data class Chapter (
    val chapterTitle: String,
    val content: ChapterContent,
    val lastRead: Int = 0,
    var isRead: Boolean = false,
    val chapterNumber: Double? = null,
)
