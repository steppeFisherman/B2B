package com.example.b2b.utils

import android.content.Context
import androidx.core.content.res.ResourcesCompat
import com.example.b2b.R

interface TextColorProvider {

    fun selected(): Int
    fun default(): Int

    class Base(private val context: Context) : TextColorProvider {

        override fun selected() = ResourcesCompat
            .getColor(context.resources, R.color.orange, null)

        override fun default() = ResourcesCompat
            .getColor(context.resources, R.color.bottom_nav_background, null)
    }
}