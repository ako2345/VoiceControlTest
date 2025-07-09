package com.example.voicecontroltest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material3.Surface
import androidx.tv.material3.Text
import com.example.voicecontroltest.extensions.onClickToast
import com.example.voicecontroltest.ui.theme.GreyLight
import com.example.voicecontroltest.ui.theme.Purple40
import com.example.voicecontroltest.ui.theme.PurpleGrey40
import com.example.voicecontroltest.ui.theme.VoiceControlTestTheme
import com.example.voicecontroltest.ui.theme.White
import com.example.voicecontroltest.ui.theme.Yellow

class BoxButtonsWithChangingTextActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VoiceControlTestTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    shape = RectangleShape
                ) {
                    Column(
                        modifier = Modifier.padding(32.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Text("Кнопки с меняющимся текстом")
                        BoxButtonWithChangingText("Описание", "Убрать", {})
                        BoxButtonWithChangingText("Фильм", "Сериал", {})
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            }
        }
    }

}

@Composable
fun BoxButtonWithChangingText(
    labelDefault: String,
    labelPressed: String,
    onClick: () -> Unit
) {
    var isFocused by remember { mutableStateOf(false) }
    var isPressed by remember { mutableStateOf(false) }
    val textColor = if (isPressed) GreyLight else White
    val buttonText = if (isPressed) labelPressed else labelDefault
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .onFocusChanged { focusState -> isFocused = focusState.isFocused }
            .clip(RoundedCornerShape(8.dp))
            .background(if (isFocused) Yellow else if (isPressed) PurpleGrey40 else Purple40)
            .focusable()
            .clickable {
                isPressed = !isPressed
                context.onClickToast(buttonText)
                onClick()
            }
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = buttonText,
            color = textColor,
            fontSize = 18.sp
        )
    }
}
