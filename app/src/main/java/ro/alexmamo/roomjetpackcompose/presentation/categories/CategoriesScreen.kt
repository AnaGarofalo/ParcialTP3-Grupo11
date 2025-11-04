package ro.alexmamo.roomjetpackcompose.presentation.categories

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.components.AppTopBar
import ro.alexmamo.roomjetpackcompose.components.BottomNavigationBar
import ro.alexmamo.roomjetpackcompose.components.CategoriesHeader
import ro.alexmamo.roomjetpackcompose.components.NotificationButton
import ro.alexmamo.roomjetpackcompose.components.OnBackNavigationButton
import ro.alexmamo.roomjetpackcompose.presentation.categories.components.GridCategories
import ro.alexmamo.roomjetpackcompose.presentation.layouts.BaseScreen

@Composable
fun CategoriesScreen(
    navController: NavHostController,
    onNavigateBack: () -> Unit = {},
    onNavigateToNotifications: () -> Unit = {}

) {
    BaseScreen(
        topBar = {
            AppTopBar(
                title = stringResource(R.string.categories),
                leftAction = {
                    OnBackNavigationButton(onNavigateBack)
                },
                rightAction = {
                    NotificationButton(onNavigateToNotifications)
                }
            )
        },
        header = {
            CategoriesHeader(
                totalBalance = 7783.00,
                totalExpense = 1187.40,
                expenseLimit = 20000.00,
                income = 4000.00,
                expense = 1187.40
            )
        },
        bottomBar = { BottomNavigationBar(navController) },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 8.dp, start = 16.dp, end = 16.dp, bottom = 56.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                GridCategories()
            }
        }
    )
}