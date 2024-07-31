package xyz.fjarm.basicstatecodelab

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

fun getWellnessTasks() = List(30) { i: Int ->
    WellnessTask(i, "Task # $i")
}

@Composable
fun WellnessTaskList(
    modifier: Modifier = Modifier,
    itemsList: List<WellnessTask> = remember {
        getWellnessTasks()
    },
) {
    LazyColumn(
        modifier = modifier,
        state = rememberLazyListState(),
    ) {
        items(items = itemsList) { task: WellnessTask ->
            WellnessTaskItem(
                taskName = task.label,
            )
        }
    }
}
