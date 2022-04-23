package com.example.b2b.screens.explorerFragment.computer

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.b2b.databinding.FragmentComputerBinding
import com.example.b2b.screens.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComputerFragment : BaseFragment<FragmentComputerBinding>() {

    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentComputerBinding.inflate(inflater, container, false)
}