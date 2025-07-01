package com.example.voicecontroltest

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material3.Surface
import androidx.tv.material3.Text
import com.example.voicecontroltest.ui.theme.PurpleGrey40
import com.example.voicecontroltest.ui.theme.VoiceControlTestTheme
import com.example.voicecontroltest.ui.theme.White
import com.example.voicecontroltest.ui.theme.Yellow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VoiceControlTestTheme {
                Surface(
                    shape = RectangleShape,
                    modifier = Modifier
                        .padding(32.dp)
                        .fillMaxSize()
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                        Text("Тестирование голосового управления")
                        SectionButton(
                            label = "Кнопки в XML (без Compose)",
                            onClick = {
                                startActivity(
                                    Intent(
                                        this@MainActivity,
                                        XmlButtonsActivity::class.java
                                    )
                                )
                            }
                        )
                        SectionButton(
                            label = "Кнопки в XML (в AndroidView)",
                            onClick = {
                                startActivity(
                                    Intent(
                                        this@MainActivity,
                                        AndroidViewButtonsActivity::class.java
                                    )
                                )
                            }
                        )
                        SectionButton(
                            label = "Кнопки с иконками",
                            onClick = {
                                startActivity(
                                    Intent(
                                        this@MainActivity,
                                        IconButtonsActivity::class.java
                                    )
                                )
                            }
                        )
                        SectionButton(
                            label = "Кнопки (Text внутри Box)",
                            onClick = {
                                startActivity(
                                    Intent(
                                        this@MainActivity,
                                        BoxButtonsActivity::class.java
                                    )
                                )
                            }
                        )
                        SectionButton(
                            label = "Кнопки с меняющимся текстом",
                            onClick = {
                                startActivity(
                                    Intent(
                                        this@MainActivity,
                                        BoxButtonsWithChangingTextActivity::class.java
                                    )
                                )
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun SectionButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var isFocused by remember { mutableStateOf(false) }
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .onFocusChanged { focusState -> isFocused = focusState.isFocused }
            .background(if (isFocused) Yellow else PurpleGrey40)
            .focusable()
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = label,
            color = White,
            fontSize = 18.sp
        )
    }
}