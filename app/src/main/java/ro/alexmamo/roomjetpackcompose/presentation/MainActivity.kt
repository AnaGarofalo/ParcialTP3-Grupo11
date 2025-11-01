package ro.alexmamo.roomjetpackcompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import ro.alexmamo.roomjetpackcompose.presentation.launch.LaunchAScreen
import ro.alexmamo.roomjetpackcompose.presentation.launch.LaunchBScreen
import ro.alexmamo.roomjetpackcompose.ui.theme.CustomTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomTheme {
                // Mostrar LaunchA primero (pantalla de carga). Cuando termine, pasar a LaunchB.
                var showLaunchA by remember { mutableStateOf(true) }

                if (showLaunchA) {
                    LaunchAScreen(onFinished = { showLaunchA = false })
                } else {
                    LaunchBScreen()
                }
            }
        }
    }
}