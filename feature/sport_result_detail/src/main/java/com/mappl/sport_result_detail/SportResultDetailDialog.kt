package com.mappl.sport_result_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SportResultDetailDialogRoute(
    viewModel: SportResultDetailViewModel = hiltViewModel()
) {
    Card() {
        Column(modifier = Modifier.padding(8.dp)) {
            TextField(
                label = { Text("Name") },
                value = viewModel.name,
                onValueChange = { viewModel.updateName(it) }
            )
            TextField(
                label = { Text("Place") },
                value = viewModel.place,
                onValueChange = { viewModel.updatePlace(it) }
            )
            TextField(
                label = { Text("Duration") },
                value = viewModel.duration,
                onValueChange = { viewModel.updateDuration(it) }
            )
        }
    }
}