package com.example.b2b.screens.explorerFragment

import androidx.navigation.NavController
import com.example.b2b.R

interface CategoryNavigate {

    fun navigate(navController: NavController, position: Int)

    class Base : CategoryNavigate {
        override fun navigate(navController: NavController, position: Int) {
            when (position) {
                0 -> navController.navigate(R.id.action_global_phonesFragment)
                1 -> navController.navigate(R.id.action_global_computerFragment)
                2 -> navController.navigate(R.id.action_global_healthFragment)
                3 -> navController.navigate(R.id.action_global_booksFragment)
                4 -> navController.navigate(R.id.action_global_othersFragment)
                5 -> navController.navigate(R.id.action_global_othersTwoFragment)
                6 -> navController.navigate(R.id.action_global_othersThreeFragment)
            }
        }
    }
}