package ro.alexmamo.roomjetpackcompose.components.transaction

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ro.alexmamo.roomjetpackcompose.ui.theme.CaribbeanGreen
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

@Composable
fun VerticalGreenDivider(height: Dp) {
    Box(
        modifier = Modifier
            .width(2.dp)
            .height(height)
            .background(CaribbeanGreen)
    )
}

@RequiresApi(Build.VERSION_CODES.O)
fun formatDateToMonthDay(dateString: String): String {
    return try {
        val date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        val formatter = DateTimeFormatter.ofPattern("MMMM d", Locale.ENGLISH)
        date.format(formatter)
    } catch (e: Exception) {
        dateString
    }
}