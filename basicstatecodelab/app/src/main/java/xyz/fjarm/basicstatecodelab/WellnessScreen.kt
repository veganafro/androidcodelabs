package xyz.fjarm.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel(),
) {
    Column(
        modifier = modifier,
    ) {
        StatefulCounter(
            modifier = Modifier,
            count = wellnessViewModel.count.value,
            onIncrement = {
                wellnessViewModel.onIncrement()
            },
        )
        WellnessTaskList(
            modifier = Modifier,
            itemsList = wellnessViewModel.tasks,
            onCloseTask = { task: WellnessTask ->
                wellnessViewModel.remove(task)
            },
            onCheckedChanged = { task: WellnessTask, newValue: Boolean ->
                wellnessViewModel.onCheckedChanged(task, newValue)
            }
        )
    }
}

@Preview
@Composable
fun WellnessScreenPreview() {
    WellnessScreen()
}
