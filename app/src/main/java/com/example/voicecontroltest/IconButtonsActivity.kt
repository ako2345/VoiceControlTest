package com.example.voicecontroltest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Surface
import androidx.tv.material3.Text
import com.example.voicecontroltest.extensions.onClickToast
import com.example.voicecontroltest.ui.theme.PurpleGrey40
import com.example.voicecontroltest.ui.theme.VoiceControlTestTheme

class IconButtonsActivity : ComponentActivity() {
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
                    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                        Text("Кнопка без contentDescription и semantics")
                        IconButton(
                            imageId = R.drawable.ic_settings,
                            onClick = {
                                onClickToast("Настройки")
                            }
                        )
                        Spacer(modifier = Modifier.height(16.dp))

                        Text("Кнопка с contentDescription (\"Уведомления\")")
                        IconButtonWithContentDescription(
                            imageId = R.drawable.ic_notifications,
                            label = "Уведомления",
                            onClick = {
                                onClickToast("Уведомления")
                            }
                        )
                        Spacer(modifier = Modifier.height(16.dp))

                        Text("Кнопка с semantics (\"Избранное\")")
                        IconButtonWithSemantics(
                            imageId = R.drawable.ic_header_bookmark_new,
                            label = "Избранное",
                            onClick = {
                                onClickToast("Избранное")
                            }
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun IconButton(
    imageId: Int,
    onClick: () -> Unit
) {
    BaseIconButton(
        enabled = true,
        shape = RoundedCornerShape(12.dp),
        onClick = onClick
    ) {
        Icon(
            modifier = Modifier.size(20.dp),
            painter = painterResource(id = imageId),
            contentDescription = null,
        )
    }
}

@Composable
fun IconButtonWithContentDescription(
    imageId: Int,
    label: String,
    onClick: () -> Unit
) {
    BaseIconButton(
        enabled = true,
        shape = RoundedCornerShape(12.dp),
        onClick = onClick
    ) {
        Icon(
            modifier = Modifier.size(20.dp),
            painter = painterResource(id = imageId),
            contentDescription = label,
        )
    }
}

@Composable
fun IconButtonWithSemantics(
    imageId: Int,
    label: String,
    onClick: () -> Unit
) {
    BaseIconButtonWithSemantics(
        enabled = true,
        label = label,
        shape = RoundedCornerShape(12.dp),
        onClick = onClick
    ) {
        Icon(
            modifier = Modifier.size(20.dp),
            painter = painterResource(id = imageId),
            contentDescription = label,
        )
    }
}

@Composable
fun BaseIconButton(
    modifier: Modifier = Modifier,
    enabled: Boolean,
    shape: Shape,
    contentPadding: PaddingValues = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit,
    content: @Composable RowScope.() -> Unit
) {
    Row(
        modifier = modifier
            .background(
                color = PurpleGrey40,
                shape = shape
            )
            .clip(shape)
            .clickable(
                enabled = enabled,
                interactionSource = interactionSource,
                indication = LocalIndication.current,
                onClick = { onClick() }
            )
            .padding(contentPadding)
    ) {
        content()
    }
}

@Composable
fun BaseIconButtonWithSemantics(
    modifier: Modifier = Modifier,
    label: String,
    enabled: Boolean,
    shape: Shape,
    contentPadding: PaddingValues = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit,
    content: @Composable RowScope.() -> Unit
) {
    Row(
        modifier = modifier
            .background(
                color = PurpleGrey40,
                shape = shape
            )
            .clip(shape)
            .clickable(
                enabled = enabled,
                interactionSource = interactionSource,
                indication = LocalIndication.current,
                onClick = { onClick() }
            )
            .semantics { contentDescription = label }
            .padding(contentPadding)
    ) {
        content()
    }
}