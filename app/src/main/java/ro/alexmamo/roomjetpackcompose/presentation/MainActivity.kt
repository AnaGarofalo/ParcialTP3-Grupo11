package ro.alexmamo.roomjetpackcompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ro.alexmamo.roomjetpackcompose.navigation.NavGraph
import ro.alexmamo.roomjetpackcompose.ui.theme.CustomTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomTheme {
                NavGraph(
                    navController = rememberNavController()
                )
            }
        }
    }
}