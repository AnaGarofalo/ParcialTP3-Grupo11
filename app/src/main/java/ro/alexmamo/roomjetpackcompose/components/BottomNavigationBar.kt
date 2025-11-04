package ro.alexmamo.roomjetpackcompose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.navigation.*

@Composable
fun BottomNavigationBar(navController: NavController) {
    val icons = listOf(
        R.drawable.home,
        R.drawable.analysis,
        R.drawable.transactions,
        R.drawable.expenses,
        R.drawable.profile
    )

    // Rutas o destinos asociados a cada ícono
    val destinations = listOf(
        HomeScreen::class.qualifiedName,
        AccountBalanceScreen::class.qualifiedName,
        TransactionScreen::class.qualifiedName,
        CategoriesScreen::class.qualifiedName,
        ProfileScreen::class.qualifiedName
    )

    val currentDestination by navController.currentBackStackEntryAsState()
    val currentRoute = currentDestination?.destination?.route

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(
                color = MaterialTheme.colorScheme.onPrimaryFixed,
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
                val isSelected = currentRoute == destinations[index]

                NavigationMenuButton(
                    iconRes = icon,
                    selected = isSelected,
                    onClick = {
                        val destination = destinations[index]
                        if (destination != null) {
                            navController.navigate(destination)
                        }
                    }
                )
            }
        }
    }
}
