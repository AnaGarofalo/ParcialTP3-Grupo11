package ro.alexmamo.roomjetpackcompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.challenge2.ui.theme.CustomTheme
import dagger.hilt.android.AndroidEntryPoint
import ro.alexmamo.roomjetpackcompose.navigation.NavGraph

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