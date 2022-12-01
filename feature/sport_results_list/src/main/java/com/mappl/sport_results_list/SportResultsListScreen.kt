package com.mappl.sport_results_list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mappl.design.theme.MyApplicationTheme
import com.mappl.model.SportResult

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun SportResultsRoute(
    navigateToResultDetail: (String) -> Unit = {
        // TODO("Navigate to result detail in detail feature")
    },
    viewModel: SportResultsListViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    SportResultsScreen(uiState = uiState, navigateToResultDetail = navigateToResultDetail)
}

@Composable
fun SportResultsScreen(
    uiState: SportResultListUiState,
    navigateToResultDetail: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    when (uiState) {
        is SportResultListUiState.Success -> {
            LazyColumn {
                items(uiState.sportResults) { sportResult ->
                    SportResultCard(sportResult, navigateToResultDetail)
                }
            }
        }
        is SportResultListUiState.Error -> {
            Text(text = "Error")
        }
        else -> {
            Text("Loading")
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SportResultCard(data: SportResult, navigateToResultDetail: (String) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        elevation = 8.dp,
        backgroundColor = MaterialTheme.colors.primary,
        onClick = { navigateToResultDetail(data.uid) }
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = data.name)
            Divider(color = MaterialTheme.colors.onPrimary, thickness = 1.dp)
            Row {
                Text(text = data.place, modifier = Modifier.weight(1f))
                Text(text = data.duration, modifier = Modifier.weight(1f))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        SportResultsScreen(
            uiState = SportResultListUiState.Success(
                listOf(
                    SportResult("", "name", "place", "duration"),
                    SportResult("", "name2", "place", "duration"),
                    SportResult("", "name3", "place", "duration"),
                )
            ),
            navigateToResultDetail = {}
        )
    }
}