package xyz.fjarm.basicstatecodelab

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import xyz.fjarm.basicstatecodelab.ui.theme.BasicStateCodelabTheme

@Composable
fun WellnessTaskItem(
    modifier: Modifier = Modifier,
    taskName: String,
    checked: Boolean,
    onClose: () -> Unit,
    onCheckedChanged: (newValue: Boolean) -> Unit,
) {
    StatelessWellnessTaskItem(
        modifier = modifier,
        taskName = taskName,
        checked = checked,
        onCheckedChanged = { newValue: Boolean ->
            onCheckedChanged(newValue)
        },
        onClose = onClose,
    )
}

@Composable
fun StatelessWellnessTaskItem(
    modifier: Modifier = Modifier,
    taskName: String,
    checked: Boolean,
    onCheckedChanged: (Boolean) -> Unit,
    onClose: () -> Unit,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp),
            text = taskName,
        )
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChanged,
        )
        IconButton(
            onClick = onClose,
        ) {
            Icon(
                imageVector = Icons.Filled.Close,
                contentDescription = "Close",
            )
        }
    }
}

@Preview
@Composable
fun WellnessTaskItemPreview() {
    BasicStateCodelabTheme {
        StatelessWellnessTaskItem(
            taskName = "Do a barrel roll",
            checked = false,
            onCheckedChanged = {},
            onClose = {},
        )
    }
}
