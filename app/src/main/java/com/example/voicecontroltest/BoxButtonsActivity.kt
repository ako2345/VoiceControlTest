package com.example.voicecontroltest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material3.Surface
import androidx.tv.material3.Text
import com.example.voicecontroltest.extensions.onClickToast
import com.example.voicecontroltest.ui.theme.PurpleGrey40
import com.example.voicecontroltest.ui.theme.VoiceControlTestTheme
import com.example.voicecontroltest.ui.theme.White

class BoxButtonsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VoiceControlTestTheme {
                Surface(
                    modifier = Modifier
                        .padding(32.dp)
                        .fillMaxSize(),
                    shape = RectangleShape
                ) {
                    var modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(color = White)
                        .border(
                            width = 2.dp,
                            color = PurpleGrey40,
                            shape = RoundedCornerShape(8.dp)
                        )

                    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                        Text("Кнопки без semantics")
                        BoxButtonDisplayingToast("Описание", modifier)
                        BoxButtonDisplayingToast("Трейлер", modifier)
                        Spacer(modifier = Modifier.height(16.dp))

                        Text("Кнопки с semantics")
                        BoxButtonWithSemanticsDisplayingToast("Избранное", modifier)
                        BoxButtonWithSemanticsDisplayingToast("Оценить", modifier)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            }
        }
    }

    @Composable
    private fun BoxButtonDisplayingToast(label: String, modifier: Modifier) {
        BoxButton(
            label = label,
            modifier = modifier,
            onClick = {
                onClickToast(label)
            }
        )
    }

    @Composable
    private fun BoxButtonWithSemanticsDisplayingToast(
        label: String,
        modifier: Modifier
    ) {
        BoxButtonWithSemantics(
            label = label,
            modifier = modifier,
            onClick = {
                onClickToast(label)
            }
        )
    }

}

@Composable
fun BoxButton(
    label: String,
    modifier: Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = label,
            color = PurpleGrey40,
            fontSize = 18.sp
        )
    }
}

@Composable
fun BoxButtonWithSemantics(
    label: String,
    modifier: Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .semantics {
                contentDescription = label
            }
    ) {
        Text(
            text = label,
            color = PurpleGrey40,
            fontSize = 18.sp
        )
    }
}