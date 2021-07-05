package org.test.myapplication

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat


fun Context?.color(resourceId: Int): Int {
    return this?.let { context ->
        ContextCompat.getColor(context, resourceId)
    } ?: android.R.color.black
}

fun Context?.closeKeyBoard(view: View?) {
    this?.run {
        val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
        imm?.hideSoftInputFromWindow(view?.windowToken, 0)
    }
}

fun <T> Context?.openActivity(it: Class<T>, extras: Bundle.() -> Unit = {}) {
    val intent = Intent(this, it)
    intent.putExtras(Bundle().apply(extras))
    this?.startActivity(intent)
}


