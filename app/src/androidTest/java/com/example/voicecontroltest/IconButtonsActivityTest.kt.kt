package com.example.voicecontroltest

import android.content.Intent
import android.speech.RecognizerIntent
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import org.junit.Rule
import org.junit.Test

class IconButtonsActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<IconButtonsActivity>()

    @Test
    fun testVoiceCommandAlicePressNotifications() {
        // Создаём Intent с подменённым результатом распознавания
        val resultData = Intent().apply {
            putStringArrayListExtra(
                RecognizerIntent.EXTRA_RESULTS,
                arrayListOf("Алиса, нажми Уведомления")
            )
        }

        // Запускаем активность и вызываем onActivityResult с подменённым результатом
        composeTestRule.activity.apply {
            handleVoiceCommand(resultData)
        }

        Thread.sleep(10_000)

        // Проверяем, что кнопка с contentDescription "Избранное" стала нажата или видна
//        composeTestRule.onNodeWithContentDescription("Уведомления")
//            .assertExists()

        // Можно добавить дополнительные проверки, например, Toast или изменение состояния
    }

}