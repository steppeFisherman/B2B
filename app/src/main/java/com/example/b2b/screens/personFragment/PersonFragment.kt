package com.example.b2b.screens.personFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.b2b.databinding.FragmentPersonBinding
import com.example.b2b.screens.BaseFragment

class PersonFragment : BaseFragment<FragmentPersonBinding>() {
    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentPersonBinding.inflate(inflater, container, false)
}