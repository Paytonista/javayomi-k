package com.manga.repositories

import com.manga.models.Manga
import com.manga.services.filesystem.FolderServices
import com.manga.services.library.LibraryServices

import androidx.compose.runtime.setValue

class LibraryRepository(
    private val folderServices: FolderServices,
    private val libraryServices: LibraryServices
) {
    suspend fun scanFolder (): List<Manga>? {
        val path = folderServices.pickFolder() ?: return null
        return libraryServices.scanFolder(path)

    }

    suspend fun rescan(path: String): List<Manga> {
        return libraryServices.scanFolder(path)
    }

}