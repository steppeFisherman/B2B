package com.example.b2b.screens.explorerFragment.books

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.b2b.databinding.FragmentBooksBinding
import com.example.b2b.screens.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BooksFragment : BaseFragment<FragmentBooksBinding>() {

    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentBooksBinding.inflate(inflater, container, false)
}