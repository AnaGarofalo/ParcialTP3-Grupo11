package ro.alexmamo.roomjetpackcompose.presentation.notification

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ro.alexmamo.roomjetpackcompose.R

class NotificationViewModel : ViewModel() {

    data class Item(
        val iconRes: Int,
        val titleRes: Int,
        val messageRes: Int,
        val timeRes: Int
    )

    data class Section(
        val titleRes: Int,
         val items: List<Item>
    )

    private val _sections = MutableStateFlow(
        listOf(
            Section(
                titleRes = R.string.today_section_title,
                items = listOf(
                    Item(R.drawable.notification, R.string.notif_reminder_title, R.string.notif_reminder_message, R.string.notification_time_example),
                    Item(R.drawable.star, R.string.notif_new_update_title, R.string.notif_reminder_message, R.string.notification_time_example),
                )
             ),
             Section(
                titleRes = R.string.yesterday_section_title,
                items = listOf(
                    Item(R.drawable.dollar, R.string.notif_transactions_title, R.string.notif_transactions_message, R.string.notification_time_example),
                    Item(R.drawable.notification, R.string.notif_reminder_title, R.string.notif_reminder_message, R.string.notification_time_example),
                )
             ),
            Section(
                titleRes = R.string.thisweekend_section_title,
                items = listOf(
                    Item(R.drawable.arrow_down, R.string.notif_expense_title, R.string.notif_expense_message, R.string.notification_time_example),
                    Item(R.drawable.dollar, R.string.notif_transactions_title, R.string.notif_transactions_message, R.string.notification_time_example),
                )
            ),
         )
     )

    val sections: StateFlow<List<Section>> = _sections
}
