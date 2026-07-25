package com.manga.services.filesystem

import androidx.compose.runtime.Composable
import com.manga.services.library.LibraryServices
import com.manga.ui.screens.library.LibraryViewModel


expect class FolderServices(){
    suspend fun pickFolder(): String?



}