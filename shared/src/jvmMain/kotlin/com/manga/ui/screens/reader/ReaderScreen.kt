package com.manga.ui.screens.reader

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.manga.models.Chapter
import com.manga.models.Manga
import com.manga.ui.screens.reader.ReaderViewModel

@Composable
fun ReaderScreen(
    manga: Manga,
    chapter: Chapter,
    viewModel: ReaderViewModel,
) {
    LaunchedEffect(chapter) {
        viewModel.loadChapter(chapter)
    }
    Column{
        Row{
            val currentImage = viewModel.imageList.getOrNull(viewModel.chapterIndex)
            AsyncImage(
                model = currentImage,
                contentDescription = null,
                modifier = Modifier.size(300.dp)
            )
            Text(text = "LOREM IPSUM LOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUMLOREM IPSUM")
        }
    }
}