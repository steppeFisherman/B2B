package com.example.b2b.screens.explorerFragment.others

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.b2b.databinding.FragmentOthersBinding
import com.example.b2b.screens.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OthersFragment : BaseFragment<FragmentOthersBinding>() {
    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentOthersBinding.inflate(inflater, container, false)
}