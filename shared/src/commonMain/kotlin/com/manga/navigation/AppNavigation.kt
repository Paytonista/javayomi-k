package com.manga.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.manga.models.Screens
import com.manga.ui.components.navigation.Sidebar
import com.manga.ui.screens.library.LibraryScreen
import com.manga.ui.screens.library.LibraryViewModel
import com.manga.ui.screens.manga.MangaScreen
import com.manga.ui.screens.manga.MangaViewModel
import com.manga.ui.screens.reader.ReaderViewModel
import com.manga.ui.screens.reader.ReaderScreen


@Composable

fun AppNavigation(
    navController: NavHostController,
    libraryView: LibraryViewModel,
    mangaView: MangaViewModel,
    readerView: ReaderViewModel,
) {

    Sidebar(navController)
    NavHost(navController = navController, startDestination = Screens.Library) {
        composable<Screens.Library> {
            LibraryScreen(
                viewModel = libraryView,
                onMangaClick = { manga ->
                    navController.navigate(Screens.Manga(mangaName = manga.mangaName))
                }
            )
        }

        composable<Screens.Manga> { backStackEntry ->
            val route: Screens.Manga = backStackEntry.toRoute()
            val manga = libraryView.mangaList.find {it.mangaName == route.mangaName}

            MangaScreen(
                manga = manga!!,
                viewModel = mangaView,
                onChapterClick = { chapter ->
                    navController.navigate(Screens.Reader(mangaName = manga.mangaName, chapterName = chapter.chapterTitle))
                }
            )
        }

        composable<Screens.Reader> { backStackEntry ->
            val route: Screens.Reader = backStackEntry.toRoute()
            val manga = libraryView.mangaList.find {it.mangaName == route.mangaName}
            val chapter = mangaView.chapterList.find {it.chapterTitle == route.chapterName}

            ReaderScreen(
                manga = manga!!,
                chapter = chapter!!,
                viewModel = readerView,
            )
        }
    }

}