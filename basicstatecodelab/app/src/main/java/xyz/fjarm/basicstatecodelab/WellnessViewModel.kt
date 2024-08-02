package xyz.fjarm.basicstatecodelab

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class WellnessViewModel : ViewModel() {

    private val _count: MutableState<Int> = mutableIntStateOf(0)
    val count: MutableState<Int>
        get() = _count
    private val _tasks: SnapshotStateList<WellnessTask> = getWellnessTasks()
        .toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _tasks

    fun onIncrement() {
        _count.value += 1
    }

    fun onCheckedChanged(task: WellnessTask, newValue: Boolean) {
        _tasks.find { item: WellnessTask ->
            item.id == task.id
        }?.let { item: WellnessTask ->
            item.checked = newValue
        }
    }

    fun remove(task: WellnessTask) {
        _tasks.remove(task)
    }
}
