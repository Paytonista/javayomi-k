package com.manga.ui.components.library

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.manga.models.Manga
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.layout.ContentScale
import coil3.compose.LocalPlatformContext
import coil3.request.ImageRequest
import coil3.size.Size

@Composable
fun MangaCard(
    manga: Manga,
    onClick: (Manga) -> Unit,
    modifier: Modifier = Modifier,
) {

    Card (
        modifier = modifier
            .clickable(onClick = { onClick(manga) }),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column{
            AsyncImage(
                model = ImageRequest.Builder(LocalPlatformContext.current)
                    .data(manga.mangaCover)
                    .size(Size.ORIGINAL) // don't downsample at all, always decode full-res
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,

                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(2f / 3f)

            )

        }
    }


}

