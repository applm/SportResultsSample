package com.mappl.sport_results_list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mappl.design.theme.MyApplicationTheme
import com.mappl.model.SportResult

@Composable
fun TestButton() {
    Button(onClick = { /*TODO*/ }) {
        Text("Button")
    }
}

@Composable
fun SportResultsList() {
    TestButton()
}

@Composable
fun SportResultCard(data: SportResult) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 8.dp,
        backgroundColor = MaterialTheme.colors.primary,
    ) {
        Column {
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
        SportResultCard(SportResult("","name", "place", "duration"))
    }
}