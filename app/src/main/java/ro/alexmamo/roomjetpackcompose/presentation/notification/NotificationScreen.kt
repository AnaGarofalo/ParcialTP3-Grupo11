package ro.alexmamo.roomjetpackcompose.presentation.notification

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.components.BottomNavigationBar
import ro.alexmamo.roomjetpackcompose.components.AppTopBar
import ro.alexmamo.roomjetpackcompose.components.NotificationItem
import ro.alexmamo.roomjetpackcompose.presentation.layouts.BaseScreen
import ro.alexmamo.roomjetpackcompose.ui.theme.Dimens
import ro.alexmamo.roomjetpackcompose.ui.theme.Honeydew

@Composable
fun NotificationScreen(vm: NotificationViewModel = viewModel()) {
    BaseScreen(
        title = null,
        topBar = {
            AppTopBar(
                title = "Notification",
                leftAction = {
                    IconButton(onClick = { /* TODO: navigate back */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.arrow_down),
                            contentDescription = "Back"
                        )
                    }
                },
                rightAction = {
                    IconButton(onClick = { /* TODO: open notifications/settings */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.notification),
                            contentDescription = "Notifications"
                        )
                    }
                }
            )
        },
        bottomBar = { BottomNavigationBar() },
        content = { _ ->
            val sections by vm.sections.collectAsState()

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(Dimens.paddingMedium),
                verticalArrangement = Arrangement.spacedBy(Dimens.paddingMedium),
                contentPadding = PaddingValues(bottom = Dimens.paddingLarge)
            ) {
                sections.forEach { section ->
                    item(key = section.title) {
                        Text(
                            text = section.title,
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.onSecondary
                        )
                    }
                    items(section.items) { item ->
                        NotificationItem(
                            iconRes = item.iconRes,
                            title = item.title,
                            message = item.message,
                            time = item.time
                        )
                        HorizontalDivider(color = Honeydew.copy(alpha = 0.12f), thickness = 1.dp)
                    }
                }
            }
        }
    )
}
