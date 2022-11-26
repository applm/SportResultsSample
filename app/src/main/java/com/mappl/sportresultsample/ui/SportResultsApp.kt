package com.mappl.sportresultsample.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.mappl.design.theme.MyApplicationTheme
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
            Scaffold { padding ->
                SportResultsNavHost(
                    navHostController = navController,
                    modifier = Modifier.padding(padding)
                )
            }
        }
    }
}