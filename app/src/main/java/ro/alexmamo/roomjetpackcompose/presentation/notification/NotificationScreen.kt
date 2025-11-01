package ro.alexmamo.roomjetpackcompose.presentation.notification

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.components.AppTopBar
import ro.alexmamo.roomjetpackcompose.components.BottomNavigationBar
import ro.alexmamo.roomjetpackcompose.components.NotificationItem
import ro.alexmamo.roomjetpackcompose.presentation.layouts.BaseScreen
import ro.alexmamo.roomjetpackcompose.ui.theme.CaribbeanGreen
import ro.alexmamo.roomjetpackcompose.ui.theme.Dimens

@Composable
fun NotificationScreen(vm: NotificationViewModel = viewModel()) {
    BaseScreen(
        title = null,
        topBar = {
            AppTopBar(
                title = stringResource(R.string.notification_title),
                leftAction = {
                    IconButton(onClick = { /* TODO: navigate back */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.arrow_left),
                            contentDescription = "Back"
                        )
                    }
                },
                rightAction = {

                    IconButton(onClick = { /* TODO: open notifications/settings */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.notification),
                            contentDescription = "Notifications",
                            modifier = Modifier
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.surface),
                            tint = MaterialTheme.colorScheme.onSecondary
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
                    item(key = section.titleRes) {
                        val sectionTitle = stringResource(id = section.titleRes)
                        Text(
                            sectionTitle,
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.onSecondary
                        )
                    }
                    items(section.items) { item ->
                        NotificationItem(
                            iconRes = item.iconRes,
                            titleRes = item.titleRes,
                            messageRes = item.messageRes,
                            timeRes = item.timeRes
                        )
                        // Divider con color de background del tema y grosor 2.dp
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = Dimens.paddingMedium)
                                .height(2.dp)
                                .background(color = MaterialTheme.colorScheme.background)
                        )
                    }
                }
            }
        }
    )
}
