package com.manga.models

import kotlinx.serialization.Serializable

sealed class Screens {
    @Serializable
    object Library : Screens()

    @Serializable
    data class Manga(val mangaName: String) : Screens()

    @Serializable
    data class Reader(val mangaName: String, val chapterName: String) : Screens()
}