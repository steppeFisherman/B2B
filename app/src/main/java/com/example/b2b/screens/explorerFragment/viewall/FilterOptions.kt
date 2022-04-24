package com.example.b2b.screens.explorerFragment.viewall

import android.content.Context
import android.widget.ArrayAdapter
import com.example.b2b.R

interface FilterOptions {

    fun provide(): List<ArrayAdapter<String>>

    class Base(
        private val context: Context
    ) : FilterOptions {
        override fun provide(): List<ArrayAdapter<String>> {

            val phonesList = context.resources.getStringArray(R.array.phones)
            val phonesAdapter =
                ArrayAdapter(context, R.layout.dropdown_item, phonesList)

            val priceRange = context.resources.getStringArray(R.array.price_range)
            val priceAdapter =
                ArrayAdapter(context, R.layout.dropdown_item, priceRange)

            val sizeRange = context.resources.getStringArray(R.array.size_range)
            val sizeAdapter =
                ArrayAdapter(context, R.layout.dropdown_item, sizeRange)

            return listOf(phonesAdapter, priceAdapter, sizeAdapter)
        }
    }
}