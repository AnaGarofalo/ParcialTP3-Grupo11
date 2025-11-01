package ro.alexmamo.roomjetpackcompose.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.OutputTransformation
import androidx.compose.foundation.text.input.TextFieldBuffer
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ro.alexmamo.roomjetpackcompose.ui.theme.Cyprus
import ro.alexmamo.roomjetpackcompose.ui.theme.LightGreen
import ro.alexmamo.roomjetpackcompose.R

@Composable
fun BaseInput(
    label: String,
    placeholder: String,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    isPassword: Boolean = false
) {
    val value = rememberTextFieldState(initialText = "")
    val showPassword = remember { mutableStateOf(false) }

    val passwordMask = object : OutputTransformation {
        override fun TextFieldBuffer.transformOutput() {
            val len = length
            replace(0, len, "●".repeat(len))
        }
    }

    Column (
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onTertiary,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
        )

        OutlinedTextField(
            state = value,
            placeholder = {
                Text(
                    text = if (showPassword.value || !isPassword) placeholder else stringResource(R.string.coded_password_placeholder),
                    color = Cyprus,
                    modifier = Modifier.alpha(0.5f),
                    fontSize = 15.sp,
                    lineHeight = 15.sp)
            },
            trailingIcon = {
                if (isPassword) {
                    IconButton(
                        onClick = {
                            showPassword.value = !showPassword.value
                        },
                        modifier = Modifier.size(24.dp)
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(
                                id = if (showPassword.value) R.drawable.eye_on else R.drawable.eye_off
                            ),
                            contentDescription = null,
                            tint = Cyprus
                        )
                    }
                }
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = LightGreen,
                unfocusedContainerColor = LightGreen,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            contentPadding = PaddingValues(
                start = 16.dp,
                end = 12.dp,
                top = 8.dp,
                bottom = 8.dp
            ),
            shape = RoundedCornerShape(18.dp),
            lineLimits = TextFieldLineLimits.SingleLine,
            modifier = Modifier
                .fillMaxWidth()
                .height(41.dp)
                .padding(0.dp),
            textStyle = MaterialTheme.typography.bodyMedium.copy(
                fontSize = 15.sp,
                lineHeight = 15.sp,
            ),
            outputTransformation = if (showPassword.value || !isPassword) null
            else passwordMask,
        )
    }
}
