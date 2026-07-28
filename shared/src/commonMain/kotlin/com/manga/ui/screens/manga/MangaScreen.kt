package com.manga.ui.screens.manga

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.manga.models.Chapter
import com.manga.models.Manga
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.ui.input.key.Key.Companion.R
import coil3.compose.AsyncImage

@Composable
fun MangaScreen(
    manga: Manga,
    viewModel: com.manga.ui.screens.manga.MangaViewModel,
    onChapterClick: (Chapter) -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.loadChapters(manga)
    }
    Column{
        Row{
            AsyncImage(
                model = manga.mangaCover,
                contentDescription = null,
                modifier = Modifier.size(300.dp)
            )
            Text(text = "LOREM IPSUM LOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUM")
        }

        LazyColumn {
            items(viewModel.chapterList) { chapter ->
                Text(
                    text = chapter.chapterTitle,
                    modifier = Modifier
                        .padding(4.dp)
                        .clickable { onChapterClick(chapter) }
                        .fillMaxWidth()
                )
            }
        }

    }

}