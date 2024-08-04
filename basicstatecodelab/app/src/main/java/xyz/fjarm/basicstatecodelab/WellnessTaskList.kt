package xyz.fjarm.basicstatecodelab

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

fun getWellnessTasks() = List(30) { i: Int ->
    WellnessTask(
        id = i,
        label = "Task # $i",
        initialChecked = false,
    )
}

@Composable
fun WellnessTaskList(
    modifier: Modifier = Modifier,
    itemsList: List<WellnessTask>,
    onCloseTask: (task: WellnessTask) -> Unit,
    onCheckedChanged: (task: WellnessTask, newValue: Boolean) -> Unit,
) {
    LazyColumn(
        modifier = modifier,
        state = rememberLazyListState(),
    ) {
        items(
            items = itemsList,
            key = { task: WellnessTask ->
                task.id
            },
        ) { task: WellnessTask ->
            WellnessTaskItem(
                taskName = task.label,
                checked = task.checked,
                onClose = {
                    onCloseTask(task)
                },
                onCheckedChanged = { newValue: Boolean ->
                    onCheckedChanged(task, newValue)
                }
            )
        }
    }
}
