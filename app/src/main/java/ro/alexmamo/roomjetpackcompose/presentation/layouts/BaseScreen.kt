package ro.alexmamo.roomjetpackcompose.presentation.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import ro.alexmamo.roomjetpackcompose.components.AppTopBar
import ro.alexmamo.roomjetpackcompose.ui.theme.Dimens

/**
 * BaseScreen:`.
 * - soporta variante centrada o normal
 * - slots: topBar, header, content, bottomBar, fab
 * - mantiene paddings y radios desde `ui.theme.Dimens`
 */

@Composable
fun BaseScreen(
    modifier: Modifier = Modifier,
    title: String? = null,
    centerContent: Boolean = false,
    topBar: (@Composable () -> Unit)? = null,
    header: (@Composable () -> Unit)? = null,
    content: @Composable (paddingValues: PaddingValues) -> Unit,
    bottomBar: (@Composable () -> Unit)? = null,
    fab: (@Composable () -> Unit)? = null,
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() }
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            // sirve para qe la camara no recorte el título del top bar.
            Box(modifier = Modifier.statusBarsPadding()) {
                when {
                    topBar != null -> topBar()
                    title != null -> AppTopBar(title = title)
                }
            }
        },
        floatingActionButton = { if (fab != null) fab() },
        floatingActionButtonPosition = FabPosition.End,
        bottomBar = { if (bottomBar != null) bottomBar() },
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { paddingValues ->
        val onlyTopPadding = PaddingValues(top = paddingValues.calculateTopPadding())

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(onlyTopPadding)
        ) {
            if (header != null) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(androidx.compose.ui.graphics.Color(0xFF00C9A7)) // Fondo verde para el header
                        .padding(
                            horizontal = Dimens.paddingLarge,
                            vertical = Dimens.paddingSmall
                        )
                ) {
                    header()
                }
            }

            // contenid prinicipal
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(
                        RoundedCornerShape(
                            topStart = 56.dp,
                            topEnd = 56.dp
                        )
                    )
                    .background(MaterialTheme.colorScheme.tertiary)
                    .padding(Dimens.paddingLarge)
            ) {
                if (centerContent) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        content(PaddingValues(0.dp))
                    }
                } else {
                    content(onlyTopPadding)
                }
            }
        }
    }
}
