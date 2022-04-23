package com.example.b2b.utils

import com.example.b2b.model.BestSellerApp

interface BestSellerAppProvider {

    fun provide(): List<BestSellerApp>

    class Base() : BestSellerAppProvider {
        override fun provide() = listOf(
            BestSellerApp(
                100, 1, false,
                "",
                150, "random_1"
            ), BestSellerApp(
                200, 2, true,
                "",
                250, "random_2"
            ),
            BestSellerApp(
                300, 3, true,
                "",
                350, "random_3"
            ), BestSellerApp(
                400, 4, false,
                "",
                450, "random_4"
            )
        )
    }
}