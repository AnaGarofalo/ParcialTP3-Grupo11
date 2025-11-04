package ro.alexmamo.roomjetpackcompose.presentation.notification

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ro.alexmamo.roomjetpackcompose.R
import javax.inject.Inject

@HiltViewModel
class NotificationViewModel @Inject constructor() : ViewModel() {

    data class Item(
        val iconRes: Int,
        val titleRes: Int,
        val messageRes: Int,
        val timeRes: Int,
        val chipMessageRes: Int? = null
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
                    Item(R.drawable.dollar, R.string.notif_transactions_title, R.string.notif_transactions_message, R.string.notification_time_example, chipMessageRes = R.string.notif_budget_message),
                    Item(R.drawable.notification, R.string.notif_reminder_title, R.string.notif_reminder_message, R.string.notification_time_example),
                )
             ),
            Section(
                titleRes = R.string.thisweekend_section_title,
                items = listOf(
                    Item(R.drawable.arrow_down, R.string.notif_expense_title, R.string.notif_expense_message, R.string.notification_time_example),
                    Item(R.drawable.dollar, R.string.notif_transactions_title, R.string.notif_transactions_message, R.string.notification_time_example, chipMessageRes = R.string.notif_budget_message2),
                )
            ),
         )
     )

    val sections: StateFlow<List<Section>> = _sections
}
