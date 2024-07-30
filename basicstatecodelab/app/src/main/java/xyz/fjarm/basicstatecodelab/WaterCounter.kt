package xyz.fjarm.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    var count by remember {
        mutableStateOf(0)
    }
    Column(
        modifier = modifier
            .padding(16.dp),
    ) {
        Text(
            text = "You have had ${count} glasses",
        )
        Button(
            modifier = Modifier
                .padding(top = 8.dp),
            onClick = {
                count += 1
            }
        ) {
            Text(
                text = "Add one",
            )
        }
    }
}

@Preview
@Composable
fun WaterCounterPreview() {
    WaterCounter()
}
