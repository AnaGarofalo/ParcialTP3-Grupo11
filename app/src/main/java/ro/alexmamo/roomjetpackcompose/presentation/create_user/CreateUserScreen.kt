package ro.alexmamo.roomjetpackcompose.presentation.create_user

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.components.LoginTitle
import ro.alexmamo.roomjetpackcompose.infraestructure.user.User
import ro.alexmamo.roomjetpackcompose.presentation.create_user.components.CreateUserForm
import ro.alexmamo.roomjetpackcompose.presentation.layouts.BaseScreen
import ro.alexmamo.roomjetpackcompose.presentation.login.components.LoginForm

@Composable
fun CreateUserScreen(
    viewModel: CreateUserViewModel = viewModel(),
    navController: NavHostController,
) {
    BaseScreen(
        centerContent = true,
        header = { LoginTitle(text = stringResource(R.string.create_account)) },
        content = {
            CreateUserForm(
                navController,
                viewModel
            )
        }
    )
}