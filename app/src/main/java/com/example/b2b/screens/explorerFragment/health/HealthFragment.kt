package com.example.b2b.screens.explorerFragment.health

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.b2b.databinding.FragmentHealthBinding
import com.example.b2b.screens.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HealthFragment : BaseFragment<FragmentHealthBinding>() {

    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentHealthBinding.inflate(inflater, container, false)
}