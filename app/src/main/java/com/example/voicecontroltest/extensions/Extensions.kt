package com.example.voicecontroltest.extensions

import android.content.Context
import android.widget.Toast

fun Context.toast(message: Any) = when (message) {
    is String -> Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    is Int -> {
        val messageToDisplay = this.resources.getString(message)
        Toast.makeText(this, messageToDisplay, Toast.LENGTH_LONG).show()
    }

    else -> {
    }
}

fun Context.onClickToast(clickedViewLabel: String) {
    toast("Нажат элемент: \"$clickedViewLabel\"")
}
