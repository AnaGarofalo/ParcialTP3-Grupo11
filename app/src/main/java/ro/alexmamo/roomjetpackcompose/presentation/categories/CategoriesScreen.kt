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
import ro.alexmamo.roomjetpackcompose.components.BottomNavigationBar
import ro.alexmamo.roomjetpackcompose.presentation.categories.components.GridCategories
import ro.alexmamo.roomjetpackcompose.presentation.layouts.BaseScreen

@Composable
fun CategoriesScreen(
    navController: NavHostController,

    ) {
    BaseScreen(
        title = stringResource(R.string.categories),
        bottomBar = { BottomNavigationBar(navController) },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                GridCategories()
            }
        }
    )
}