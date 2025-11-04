package ro.alexmamo.roomjetpackcompose.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    background = FenceGreen,
    onBackground = FenceGreen,
    surface = Cyprus,
    onPrimary = Void,
    onSecondary = Honeydew,
    onTertiary = LightGreen, // usado para la mayoría de los textos
    inverseSurface = Honeydew,
    onSurface = Honeydew,
    surfaceBright = CaribbeanGreen,
    inverseOnSurface = CaribbeanGreen,
    secondary = Honeydew,
    tertiary = DarkGreen,
    onPrimaryFixed = Cyprus,
    outline = LightGreen,
    tertiaryContainer = OceanBlue,
    onSurfaceVariant = VividBlue,
    tertiaryFixed = CaribbeanGreen,
    onTertiaryFixed = VividBlue
)

private val LightColorScheme = lightColorScheme(
    background = CaribbeanGreen,
    onBackground = Honeydew,
    surface = Honeydew,
    onPrimary = Void,
    onSecondary = Void,
    onTertiary = FenceGreen, // usado para la mayoría de los textos
    surfaceBright = OceanBlue,
    inverseOnSurface = VividBlue,
    inverseSurface = Cyprus,
    onSurface = CaribbeanGreen,
    secondary = FenceGreen,
    tertiary = Honeydew,
    onPrimaryFixed = LightGreen,
    outline = CaribbeanGreen,
    tertiaryContainer = LightGreen,
    onSurfaceVariant = OceanBlue,
    tertiaryFixed = Cyprus,
    onTertiaryFixed = LightGreen
    /* Other default colors to override
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun CustomTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}