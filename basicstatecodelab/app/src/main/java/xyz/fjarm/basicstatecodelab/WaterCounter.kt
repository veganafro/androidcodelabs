package xyz.fjarm.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun WaterCounter(
    modifier: Modifier = Modifier,
    count: Int,
    onIncrement: () -> Unit,
 ) {
    StatefulCounter(
        modifier = modifier,
        count = count,
        onIncrement = onIncrement,
    )
}

@Composable
fun StatefulCounter(
    modifier: Modifier = Modifier,
    count: Int,
    onIncrement: () -> Unit,
) {
    StatelessCounter(
        modifier = modifier,
        count = count,
        onIncrement = onIncrement,
    )
}

@Composable
fun StatelessCounter(
    modifier: Modifier = Modifier,
    count: Int,
    onIncrement: () -> Unit,
) {
    Column(
        modifier = modifier
            .padding(16.dp),
    ) {
        if (count > 0) {
            Text(
                text = "You've had $count glasses.",
            )
        }
        Button(
            modifier = Modifier
                .padding(top = 8.dp),
            enabled = count < 10,
            onClick = onIncrement,
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
    WaterCounter(
        modifier = Modifier,
        count = 0,
        onIncrement = {},
    )
}
