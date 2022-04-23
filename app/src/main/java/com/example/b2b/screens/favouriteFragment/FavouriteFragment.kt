package com.example.b2b.screens.favouriteFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.b2b.databinding.FragmentFavouriteBinding
import com.example.b2b.screens.BaseFragment

class FavouriteFragment : BaseFragment<FragmentFavouriteBinding>() {
    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentFavouriteBinding.inflate(inflater, container, false)
}