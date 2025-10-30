package ro.alexmamo.roomjetpackcompose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import ro.alexmamo.roomjetpackcompose.R

@Composable
fun BottomNavigationBar() {
    var selectedIndex by remember { mutableStateOf(0) }

    val icons = listOf(
        R.drawable.home,
        R.drawable.analysis,
        R.drawable.transactions,
        R.drawable.expenses,
        R.drawable.profile
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(
                color = MaterialTheme.colorScheme.surface, // o background, según prefieras
                shape = RoundedCornerShape(topStart = 70.dp, topEnd = 70.dp)
            ),
            contentAlignment = Alignment.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            icons.forEachIndexed { index, icon ->
                NavigationMenuButton(
                    iconRes = icon,
                    selected = index == selectedIndex,
                    onClick = { selectedIndex = index }
                )
            }
        }
    }
}


