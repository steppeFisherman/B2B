package com.example.b2b.screens.explorerFragment.others3

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.b2b.databinding.FragmentOthersThreeBinding
import com.example.b2b.screens.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OthersThreeFragment : BaseFragment<FragmentOthersThreeBinding>() {
    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentOthersThreeBinding.inflate(inflater, container, false)
}