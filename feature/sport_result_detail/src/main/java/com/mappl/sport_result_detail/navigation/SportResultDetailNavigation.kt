package com.mappl.sport_result_detail.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import com.mappl.sport_result_detail.SportResultDetailDialogRoute

const val sportResultDetailRoute = "sport_result_detail"

fun NavController.navigateToSportResultDetail(navOptions: NavOptions? = null) {
    this.navigate(sportResultDetailRoute, navOptions)
}

fun NavGraphBuilder.sportResultDetailDialog(navController: NavController) {
    dialog(route = sportResultDetailRoute) {
        SportResultDetailDialogRoute(navController)
    }
}