package ro.alexmamo.roomjetpackcompose.presentation.profile

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.components.BottomNavigationBar
import ro.alexmamo.roomjetpackcompose.presentation.layouts.BaseScreen
import ro.alexmamo.roomjetpackcompose.presentation.profile.components.ApiUserSection
import ro.alexmamo.roomjetpackcompose.presentation.profile.components.DBUserSection
import androidx.navigation.NavHostController

@Composable
fun ProfileScreen(
    navController: NavHostController,
) {
    BaseScreen(
        title = "",
        centerContent = true,
        content = {
            Text(stringResource(R.string.api_user))
            ApiUserSection()

            Spacer(modifier = Modifier.height(32.dp))


            Text(stringResource(R.string.db_users))
            DBUserSection()
        },
        bottomBar = { BottomNavigationBar(navController) }
    )

}