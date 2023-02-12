package com.godjoy.spacesounds.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.godjoy.spacesounds.presentation.ui.photo.detail.PhotoDetailFragment
import com.godjoy.spacesounds.presentation.ui.photo.search.PhotoSearchFragment
import com.godjoy.spacesounds.utils.Const.DETAIL_PHOTO
import com.godjoy.spacesounds.utils.Const.DETAIL_PHOTO_ARG
import com.godjoy.spacesounds.utils.Const.SEARCH_PHOTO

sealed class Route(val route: String) {
    object SearchPhoto: Route(SEARCH_PHOTO)
    object DetailPhoto: Route("$DETAIL_PHOTO/{$DETAIL_PHOTO_ARG}") {
        fun createRoute(nasaId: String) = "$DETAIL_PHOTO/$nasaId"
    }
}

@Composable
fun SpaceSoundsApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Route.SearchPhoto.route) {
        composable(route = Route.SearchPhoto.route) {
            PhotoSearchFragment(
                goDetailScreen = { nasaId ->
                    navController.navigate(Route.DetailPhoto.createRoute(nasaId))
                }
            )
        }
        composable(
            route = Route.DetailPhoto.route,
            arguments = listOf(
                navArgument(DETAIL_PHOTO_ARG) {
                    type = NavType.StringType
                }
            )
        ) { navBackStackEntry ->
            val nasaId = navBackStackEntry.arguments?.getString(DETAIL_PHOTO_ARG)
            requireNotNull(nasaId) { "parameter 'nasaId' wasn't found!" }
            PhotoDetailFragment(nasaId = nasaId)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SpaceSoundsAppPreview() {
    SpaceSoundsApp()
}