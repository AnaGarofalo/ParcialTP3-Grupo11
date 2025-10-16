package ro.alexmamo.roomjetpackcompose.presentation.todo_list.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun NameText(
    title: String
) {
    Text(
        text = title,
        color = Color.DarkGray,
        fontSize = 25.sp
    )
}