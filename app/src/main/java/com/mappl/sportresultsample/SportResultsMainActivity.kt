package com.mappl.sportresultsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mappl.model.SportResult
import com.mappl.sportresultsample.ui.theme.MyApplicationTheme

class SportResultsMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SportResultsList()
                }
            }
        }
    }
}

//todo: move to core:ui
@Composable
fun SportResultsList() {
    TestButton()
}

//todo: move to core:ui
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
            Row() {
                Text(text = data.place, modifier = Modifier.weight(1f))
                Text(text = data.duration, modifier = Modifier.weight(1f))
            }
        }
    }
}



@Composable
fun TestButton() {
    Button(onClick = { /*TODO*/ }) {
        Text("Button")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        SportResultCard(SportResult("","name", "place", "duration"))
    }
}