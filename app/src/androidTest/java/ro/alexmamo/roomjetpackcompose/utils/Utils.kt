package ro.alexmamo.roomjetpackcompose.utils

import android.content.Context
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.domain.model.Todo

fun getTodoTest(context: Context): Todo {
    return Todo(
        id = 1,
        name = context.getString(R.string.name_test),
        description = context.getString(R.string.description_test)
    )
}

fun getUpdatedTodoTest(context: Context): Todo {
    return getTodoTest(context).copy(
        name = context.getString(R.string.new_name_test)
    )
}