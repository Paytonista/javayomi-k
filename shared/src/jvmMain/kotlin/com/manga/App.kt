package com.manga

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.manga.models.Screens
import com.manga.ui.screens.library.LibraryViewModel
import com.manga.ui.screens.library.MangaViewModel
import com.manga.ui.screens.library.LibraryScreen
import com.manga.ui.screens.library.MangaScreen
import androidx.navigation.toRoute

@Preview
@Composable
fun App() {

    val navController = rememberNavController()
    val libraryViewModel = remember { LibraryViewModel() }
    val mangaViewModel = remember { MangaViewModel() }

    NavHost(navController = navController, startDestination = Screens.Library) {
        composable<Screens.Library> {
            LibraryScreen(
                viewModel = libraryViewModel,
                onMangaClick = { manga ->
                    navController.navigate(Screens.Manga(mangaName = manga.mangaName))
                }
            )
        }

        composable<Screens.Manga> { backStackEntry ->
            val route: Screens.Manga = backStackEntry.toRoute()
            val manga = libraryViewModel.mangaList.find {it.mangaName == route.mangaName}

            MangaScreen(
                manga = manga!!,
                viewModel = mangaViewModel,
                onChapterClick = { chapter ->
                    navController.navigate(Screens.Reader(mangaName = manga.mangaName, chapterName = chapter.chapterTitle))
                }
            )
        }


        }
    }



