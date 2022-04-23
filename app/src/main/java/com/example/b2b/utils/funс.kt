package com.example.b2b.utils

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.StringRes
import com.bumptech.glide.Glide
import com.example.b2b.R
import com.google.android.material.snackbar.Snackbar

fun View.showSnackLong(message: Int) {
    Snackbar.make(this, message, Snackbar.LENGTH_LONG)
        .show()
    this.textAlignment = View.TEXT_ALIGNMENT_CENTER
}

fun showToastLong(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
}

fun getString(context: Context, @StringRes id: Int): String =
    context.resources.getString(id)

fun glideLoad(view: ImageView, url: String) {
    Glide.with(view.context)
        .load(url)
        .error(R.drawable.holder)
        .into(view)
}
