package com.example.voicecontroltest

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.RadioGroup
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import com.example.voicecontroltest.extensions.toast

class XmlButtonsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_xml_buttons)

        setupButtonClickListeners()
    }

    private fun setupButtonClickListeners() {
        // Обычная текстовая кнопка
        findViewById<Button>(R.id.btn_text).setOnClickListener {
            toast("Нажата обычная текстовая кнопка")
        }

        // Кнопка с иконкой
        findViewById<Button>(R.id.btn_with_icon).setOnClickListener {
            toast("Нажата кнопка с иконкой")
        }

        // ImageButton
        findViewById<ImageButton>(R.id.btn_image).setOnClickListener {
            toast("Нажата кнопка-изображение")
        }

        // ToggleButton
        findViewById<ToggleButton>(R.id.btn_toggle).setOnClickListener { toggleButton ->
            val isChecked = (toggleButton as ToggleButton).isChecked
            val status = if (isChecked) "включен" else "выключен"
            toast("Переключатель сейчас $status")
        }

        // RadioButton группа
        val radioGroup = findViewById<RadioGroup>(R.id.radio_group)
        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            val selectedText = when (checkedId) {
                R.id.radio_option1 -> "Выбран вариант 1"
                R.id.radio_option2 -> "Выбран вариант 2"
                else -> "Неизвестный вариант"
            }
            toast(selectedText)
        }
    }

}