package com.example.project_andr

import android.content.Context
import android.view.View
import android.widget.EditText
import android.widget.Toast
fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}
fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun EditText.trimmedText(): String = text.toString().trim()
fun Double.toAcademicRanking(): String = when {
    this >= 3.6 -> "Xuất sắc"
    this >= 3.2 -> "Giỏi"
    this >= 2.5 -> "Khá"
    else -> "Trung bình"
}