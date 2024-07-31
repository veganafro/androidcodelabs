package xyz.fjarm.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
    ) {
        StatefulCounter(
            modifier = Modifier,
        )
        val list = remember {
            getWellnessTasks().toMutableStateList()
        }
        WellnessTaskList(
            modifier = Modifier,
            itemsList = list,
            onCloseTask = { task: WellnessTask ->
                list.remove(task)
            }
        )
    }
}

@Preview
@Composable
fun WellnessScreenPreview() {
    WellnessScreen()
}
