package xyz.fjarm.basicstatecodelab

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {
    WaterCounter(modifier = modifier)
}

@Preview
@Composable
fun WellnessScreenPreview() {
    WellnessScreen()
}
