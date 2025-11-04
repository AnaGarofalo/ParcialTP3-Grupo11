package ro.alexmamo.roomjetpackcompose.presentation.categories.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextAlign
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.components.ButtonCategoriesMenuPrimaryAndSecondary

@Composable
fun GridCategories() {

    var selectedIndex by remember { mutableStateOf(-1) }

    val categories = listOf(
        Pair(R.drawable.food, "Food"),
        Pair(R.drawable.transport, "Transport"),
        Pair(R.drawable.medicine, "Medicine"),
        Pair(R.drawable.groceries, "Groceries"),
        Pair(R.drawable.rent, "Rent"),
        Pair(R.drawable.gift, "Gifts"),
        Pair(R.drawable.savings, "Savings"),
        Pair(R.drawable.entertainment, "Entertainment"),
        Pair(R.drawable.more, "More")
    )

    // Grilla de 3 columnas
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        categories.chunked(3).forEach { rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                rowItems.forEachIndexed { index, item ->
                    val globalIndex = categories.indexOf(item)
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        ButtonCategoriesMenuPrimaryAndSecondary(
                            iconRes = item.first,
                            selected = selectedIndex == globalIndex,
                            onClick = { selectedIndex = globalIndex },
                            width = 105.dp,
                            height = 97.dp,
                            iconSize = 50.dp,
                            cornerRadius = 26.dp
                        )
                        Text(
                            text = item.second,
                            color = MaterialTheme.colorScheme.onSecondary,
                            style = MaterialTheme.typography.labelMedium,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}