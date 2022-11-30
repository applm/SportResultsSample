package com.mappl.sportresultsample.ui

import android.os.Bundle
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.mappl.design.theme.MyApplicationTheme
import com.mappl.sport_result_detail.navigation.sportResultDetailRoute
import com.mappl.sport_results_list.navigation.sportResultsListRoute
import com.mappl.sportresultsample.navigation.SportResultsNavHost

@Composable
fun SportResultsApp() {
    val navController = rememberNavController()

    MyApplicationTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Scaffold(floatingActionButton = {
                FloatingActionButton(onClick = { navController.navigate(sportResultDetailRoute) }) {
                    Text(text = "+", style = MaterialTheme.typography.h4)
                }
            }) { padding ->
                SportResultsNavHost(
                    navHostController = navController,
                    modifier = Modifier.padding(padding)
                )
            }
        }
    }
}