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
import com.manga.models.Chapter
import com.manga.models.Manga

@Composable
fun MangaScreen(
    manga: Manga,
    viewModel: MangaViewModel,
    onChapterClick: (Chapter) -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.loadChapters(manga)
    }

    LazyColumn {
        items(viewModel.chapterList) { chapter ->
            Text(
                text = chapter.chapterTitle,
                modifier = Modifier
                    .padding(16.dp)
                    .clickable { onChapterClick(chapter) }
            )
        }
    }
}