package com.example.pokertrainer

import android.app.Dialog
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat

fun hideSystemUI(window : Window, mainContainer : View) {
    WindowCompat.setDecorFitsSystemWindows(window, false)
    WindowInsetsControllerCompat(window, mainContainer).let { controller ->
        controller.hide(WindowInsetsCompat.Type.systemBars())
        controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
    }
}

fun hideDialogUI(dialog: Dialog, activity : AppCompatActivity) {
    val dialogWindow : Window? = dialog.window
    if (dialogWindow != null) {
        hideSystemUI(dialogWindow, View(activity))
    }

}