package com.manga.models

data class Manga (
    val mangaName: String,
    val mangaCover: String?,
    val chapters: List<Chapter>,
    val isFavorite: Boolean = false,
    val dateAdded: Long = System.currentTimeMillis()
) {
    val totalChapters: Int get() = chapters.size
    val isDoneReading: Boolean get() = chapters.all { it.isRead }
}
