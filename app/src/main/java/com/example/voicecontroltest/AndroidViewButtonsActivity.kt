package com.example.voicecontroltest

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageButton
import android.widget.RadioGroup
import android.widget.ToggleButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.example.voicecontroltest.extensions.toast

class AndroidViewButtonsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            XmlButtonsScreen()
        }
    }
}

@Composable
fun XmlButtonsScreen() {
    AndroidView(
        factory = { ctx ->
            val view = LayoutInflater.from(ctx).inflate(R.layout.activity_xml_buttons, null)

            view.findViewById<Button>(R.id.btn_text).setOnClickListener {
                ctx.toast("Нажата обычная текстовая кнопка")
            }

            view.findViewById<Button>(R.id.btn_with_icon).setOnClickListener {
                ctx.toast("Нажата кнопка с иконкой")
            }

            view.findViewById<ImageButton>(R.id.btn_image).setOnClickListener {
                ctx.toast("Нажата кнопка-изображение")
            }

            view.findViewById<ToggleButton>(R.id.btn_toggle).setOnClickListener { toggleButton ->
                val isChecked = (toggleButton as ToggleButton).isChecked
                val status = if (isChecked) "включен" else "выключен"
                ctx.toast("Переключатель сейчас $status")
            }

            val radioGroup = view.findViewById<RadioGroup>(R.id.radio_group)
            radioGroup.setOnCheckedChangeListener { _, checkedId ->
                val selectedText = when (checkedId) {
                    R.id.radio_option1 -> "Выбран вариант 1"
                    R.id.radio_option2 -> "Выбран вариант 2"
                    else -> "Неизвестный вариант"
                }
                ctx.toast(selectedText)
            }

            view
        },
        modifier = Modifier.fillMaxSize()
    )
}
