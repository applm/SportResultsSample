package com.mappl.sportresultsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.mappl.design.theme.MyApplicationTheme
import com.mappl.model.SportResult
import com.mappl.sport_results_list.SportResultCard
import com.mappl.sportresultsample.ui.SportResultsApp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SportResultsMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SportResultsApp()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        SportResultCard(SportResult("","name", "place", "duration"))
    }
}