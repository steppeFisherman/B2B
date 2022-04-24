package com.example.b2b.screens.explorerFragment.others2

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.b2b.databinding.FragmentOthersTwoBinding
import com.example.b2b.screens.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OthersTwoFragment : BaseFragment<FragmentOthersTwoBinding>() {
    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentOthersTwoBinding.inflate(inflater, container, false)
}