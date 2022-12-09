package com.mappl.sport_result_detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun SportResultDetailDialogRoute(
    navController: NavController,
    viewModel: SportResultDetailViewModel = hiltViewModel()
) {
    Card {
        if (viewModel.isSaving) {
            CircularProgressIndicator(modifier = Modifier.padding(24.dp))
        } else {
            Column(modifier = Modifier.padding(8.dp)) {
                TextField(label = { Text("Name") },
                    value = viewModel.name,
                    onValueChange = { viewModel.updateName(it) })
                TextField(label = { Text("Place") },
                    value = viewModel.place,
                    onValueChange = { viewModel.updatePlace(it) })
                TextField(label = { Text("Duration") },
                    value = viewModel.duration,
                    onValueChange = { viewModel.updateDuration(it) })
                Row(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth()
                ) {
                    Button(
                        modifier = Modifier
                            .weight(0.5f)
                            .padding(horizontal = 8.dp),
                        onClick = { navController.popBackStack() }
                    ) {
                        Text(text = "Cancel")
                    }
                    Button(modifier = Modifier
                        .weight(0.5f)
                        .padding(horizontal = 8.dp),
                        onClick = {
                            viewModel.onSaveClicked {
                                navController.popBackStack()
                            }
                        }
                    ) {
                        Text(text = "Save")
                    }
                }
            }
        }
    }
}