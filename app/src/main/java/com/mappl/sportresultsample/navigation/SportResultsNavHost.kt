package com.mappl.sportresultsample.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mappl.sport_result_detail.navigation.sportResultDetailDialog
import com.mappl.sport_results_list.navigation.sportResultsListRoute
import com.mappl.sport_results_list.navigation.sportResultsListScreen

@Composable
fun SportResultsNavHost (
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navHostController,
        startDestination = sportResultsListRoute,
        modifier = modifier
    ) {
        sportResultsListScreen()
        sportResultDetailDialog()
    }
}