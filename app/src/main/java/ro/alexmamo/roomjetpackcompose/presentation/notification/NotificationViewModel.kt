package ro.alexmamo.roomjetpackcompose.presentation.notification

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ro.alexmamo.roomjetpackcompose.R

class NotificationViewModel : ViewModel() {

    data class Item(
        val iconRes: Int,
        val title: String,
        val message: String,
        val time: String
    )

    data class Section(
        val title: String,
        val items: List<Item>
    )

    private val _sections = MutableStateFlow(
        listOf(
            Section(
                title = "Today",
                items = listOf(
                    Item(R.drawable.notification, "Reminder!", "Set up your automatic savings to meet your savings goal...", "17:00 - April 24"),
                    Item(R.drawable.star, "New Update", "Set up your automatic savings to meet your savings goal...", "17:00 - April 24"),
                )
            ),
            Section(
                title = "Yesterday",
                items = listOf(
                    Item(R.drawable.transactions, "Transactions", "A new transaction has been registered\nGroceries | Pantry | -$100,00", "17:00 - April 24"),
                )
            ),
        )
    )

    val sections: StateFlow<List<Section>> = _sections
}
