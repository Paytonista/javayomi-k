package com.manga.ui.screens.library

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.manga.models.Manga

@Composable
fun LibraryScreen(
    viewModel: LibraryViewModel,
    onMangaClick: (Manga) -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.loadLibrary("C:\\Users\\kenne\\OneDrive\\Desktop\\TestLibrary")
    }

    LazyColumn {
        items(viewModel.mangaList) { manga ->
            Text(
                text = manga.mangaName,
                modifier = Modifier
                    .padding(16.dp)
                    .clickable { onMangaClick(manga) }
            )
        }
    }
}