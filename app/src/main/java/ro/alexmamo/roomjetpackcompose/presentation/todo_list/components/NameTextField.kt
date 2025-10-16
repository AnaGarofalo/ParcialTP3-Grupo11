package ro.alexmamo.roomjetpackcompose.presentation.todo_list.components

import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import ro.alexmamo.roomjetpackcompose.R

@Composable
fun NameTextField(
    name: String,
    onUpdateName: (String) -> Unit
) {
    var name by remember { mutableStateOf(TextFieldValue(
        text = name,
        selection = TextRange(name.length)
    )) }
    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

    TextField(
        modifier = Modifier.focusRequester(focusRequester),
        value = name,
        onValueChange = { newName ->
            name = newName
            onUpdateName(newName.text)
        },
        placeholder = {
            Text(
                text = stringResource(
                    id = R.string.todo_name
                )
            )
        }
    )
}