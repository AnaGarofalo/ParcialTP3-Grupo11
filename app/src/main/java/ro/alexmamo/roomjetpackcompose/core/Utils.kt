package ro.alexmamo.roomjetpackcompose.core

import android.content.Context
import android.util.Log
import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.makeText
import androidx.compose.material.SnackbarHostState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

const val TAG = "AppTag"

//const val TAG = "AppTag"
const val TODO_TABLE = "todo_table"
const val NAME_FIELD = "name"
const val DESCRIPTION_FIELD = "description"

fun logMessage(
    message: String
) = Log.e(TAG, message)

fun showToastMessage(
    context: Context,
    message: String
) = makeText(context, message, LENGTH_LONG).show()

fun showSnackbarMessage(
    coroutineScope: CoroutineScope,
    snackbarHostState: SnackbarHostState,
    message: String
) = coroutineScope.launch {
    snackbarHostState.showSnackbar(message)
}