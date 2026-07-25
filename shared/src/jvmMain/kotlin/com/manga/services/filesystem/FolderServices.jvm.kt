package com.manga.services.filesystem


import io.github.vinceglb.filekit.FileKit
import io.github.vinceglb.filekit.dialogs.openDirectoryPicker
import io.github.vinceglb.filekit.path

actual class FolderServices actual constructor(
) {
    actual suspend fun pickFolder(): String? {
        val directory  = FileKit.openDirectoryPicker()
        if (directory != null) {
            return directory.path
        } else {
            println("Error 404: Directory not valid")
            return null
        }

    }
}