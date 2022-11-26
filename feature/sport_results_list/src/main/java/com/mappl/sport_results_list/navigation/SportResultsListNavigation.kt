package com.mappl.sport_results_list.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.mappl.sport_results_list.SportResultsRoute

const val sportResultsListRoute = "sport_results_list"

fun NavController.navigateToSportResultsList(navOptions: NavOptions? = null) {
    this.navigate(sportResultsListRoute, navOptions)
}

fun NavGraphBuilder.sportResultsListScreen() {
    composable(route = sportResultsListRoute) {
        SportResultsRoute()
    }
}