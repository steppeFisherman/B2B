package com.example.b2b

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.b2b.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private var _binding: ActivityMainBinding? = null
    private val mBinding get() = _binding!!

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        _binding = ActivityMainBinding.inflate(layoutInflater)
        /**
        Changes statusBar text/icons color, when the statusBar background is white or transparent
        (this works with API level 21 and higher)
         */
        WindowInsetsControllerCompat(window, window.decorView)
            .isAppearanceLightStatusBars = true
        setContentView(mBinding.root)
        initialise()
        bottomNavIconSetup()
    }

    private fun initialise() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        mBinding.bottomNavView.itemIconTintList = null
        mBinding.bottomNavView.setupWithNavController(navController)
    }

    private fun bottomNavIconSetup() {
        mBinding.bottomNavView.menu.clear()
        val view = LayoutInflater.from(this)
            .inflate(R.layout.bottom_nav_expl, mBinding.bottomNavView, false)
        mBinding.bottomNavView.addView(view)
        mBinding.bottomNavView.inflateMenu(R.menu.bottom_navigation_menu)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}