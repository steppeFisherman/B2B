package com.example.b2b.screens.explorerFragment

import com.example.b2b.R
import com.example.b2b.model.Category

interface CategoryProvide {

    fun default(): List<Category>
    fun selected(): List<Category>

    class Base : CategoryProvide {

        override fun default() = listOf(
            Category(0, "Phones", R.drawable.ic_img_phone),
            Category(1, "Computer", R.drawable.ic_img_computer),
            Category(2, "Health", R.drawable.ic_img_health),
            Category(3, "Books", R.drawable.ic_img_books),
            Category(4, "Others", R.drawable.ic_img_random),
            Category(5, "OthersTwo", R.drawable.ic_img_random),
            Category(6, "OthersThree", R.drawable.ic_img_random),
        )

        override fun selected(): List<Category> = listOf(
            Category(0, "Phones", R.drawable.ic_img_phone_selected),
            Category(1, "Computer", R.drawable.ic_img_computer_selected),
            Category(2, "Health", R.drawable.ic_img_health_selected),
            Category(3, "Books", R.drawable.ic_img_books_selected),
            Category(4, "Others", R.drawable.ic_img_random_selected),
            Category(5, "OthersTwo", R.drawable.ic_img_random_selected),
            Category(6, "OthersThree", R.drawable.ic_img_random_selected),
        )
    }
}
