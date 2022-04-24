package com.example.b2b.screens.basketFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.b2b.databinding.FragmentBasketBinding
import com.example.b2b.screens.BaseFragment

class BasketFragment : BaseFragment<FragmentBasketBinding>() {
    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentBasketBinding.inflate(inflater, container, false)
}