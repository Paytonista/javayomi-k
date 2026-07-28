package com.manga.ui.screens.library

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp

import com.manga.ui.components.library.MangaCard
import com.manga.models.Manga

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material.icons.filled.Add
import androidx.compose.ui.Alignment

@Composable
fun LibraryScreen(
    viewModel: LibraryViewModel,
    onMangaClick: (Manga) -> Unit
) {
    Box {
        Column {
            Row(modifier = Modifier.fillMaxWidth()
                .padding(4.dp)) {
                TextButton(onClick = {
                    viewModel.addToLibrary()
                },
                    shape = RectangleShape,
                    border = BorderStroke(1.dp, Color.LightGray),

                    ) {
                    Text("Refresh")
                }
                Spacer(modifier = Modifier.weight(.04f))

                TextButton(onClick = {
                    viewModel.addToLibrary()
                },
                    shape = RectangleShape,
                    border = BorderStroke(1.dp, Color.LightGray),
                    contentPadding = PaddingValues(horizontal = 2.dp, vertical = 2.dp),

                    ) {
                    Text("Layout")
                }
                Spacer(modifier = Modifier.weight(.04f))
                TextButton(onClick = {
                    viewModel.addToLibrary()
                },
                    shape = RectangleShape,
                    border = BorderStroke(1.dp, Color.LightGray),

                    ) {
                    Text("Filters")
                }

                Spacer(modifier = Modifier
                    .weight(1f, true)
                )


        }

            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 140.dp),
                contentPadding = PaddingValues(8.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier
                    .background(Color(0x2B2B2B))
                    .fillMaxHeight()
                    .fillMaxWidth()
            ) {
                items(viewModel.mangaList) { manga ->
                    MangaCard(manga = manga, onMangaClick )
                }
            }



        }


        FloatingActionButton(
            onClick = { viewModel.addToLibrary() },
            shape = CircleShape,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomEnd)

        ) {
            Icon(Icons.Default.Add, contentDescription = "Add to library")
        }
    }
}