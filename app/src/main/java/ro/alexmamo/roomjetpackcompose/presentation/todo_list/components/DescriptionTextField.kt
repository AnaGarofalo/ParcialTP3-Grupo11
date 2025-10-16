package ro.alexmamo.roomjetpackcompose.presentation.todo_list.components

import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import ro.alexmamo.roomjetpackcompose.R

@Composable
fun DescriptionTextField(
    description: String,
    onUpdateDescription: (String) -> Unit
) {
    var description by remember { mutableStateOf(description) }

    TextField(
        value = description,
        onValueChange = { newDescription ->
            description = newDescription
            onUpdateDescription(newDescription)
        },
        placeholder = {
            Text(
                text = stringResource(
                    id = R.string.todo_description
                )
            )
        }
    )
}