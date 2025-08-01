package com.example.voicecontroltest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Surface
import androidx.tv.material3.Text
import com.example.voicecontroltest.extensions.onClickToast
import com.example.voicecontroltest.ui.theme.Grey
import com.example.voicecontroltest.ui.theme.GreyLight
import com.example.voicecontroltest.ui.theme.Purple40
import com.example.voicecontroltest.ui.theme.PurpleGrey40
import com.example.voicecontroltest.ui.theme.VoiceControlTestTheme
import com.example.voicecontroltest.ui.theme.White
import com.example.voicecontroltest.ui.theme.Yellow

class ButtonsWithChangingStateActivity : ComponentActivity() {
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
                        Text("Обычная кнопка (для удержания фокуса)")
                        BoxButton(
                            "Обычная кнопка", Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .background(color = White)
                                .border(
                                    width = 2.dp,
                                    color = PurpleGrey40,
                                    shape = RoundedCornerShape(8.dp)
                                )
                        ) { onClickToast("Нажата обычная кнопка") }
                        Spacer(modifier = Modifier.height(16.dp))

                        Text("Кнопка с меняющимся состоянием ('Настройки', 'Обновить')")
                        ButtonWithChangingState()
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            }
        }
    }

}

@Composable
fun ButtonWithChangingState() {
    var isSelected by remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()
    val backgroundColor = if (isFocused) Yellow else Grey
    val tintColor = if (isSelected) Purple40 else GreyLight
    val imageRes = if (isSelected) R.drawable.ic_refresh else R.drawable.ic_settings
    val contentDescription = if (isSelected) "Обновить" else "Настройки"
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(backgroundColor, shape = RoundedCornerShape(12.dp))
            .focusable(interactionSource = interactionSource)
            .clickable { isSelected = !isSelected },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = contentDescription,
            colorFilter = ColorFilter.tint(tintColor),
            modifier = Modifier.size(64.dp)
        )
    }
}
