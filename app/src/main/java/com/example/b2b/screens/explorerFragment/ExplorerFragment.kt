package com.example.b2b.screens.explorerFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.b2b.R
import com.example.b2b.adapters.ExplorerAdapter
import com.example.b2b.databinding.FragmentExplorerBinding
import com.example.b2b.screens.BaseFragment
import com.example.b2b.utils.TextColorProvider
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExplorerFragment : BaseFragment<FragmentExplorerBinding>(), ExplorerAdapter.OnClick {

    private lateinit var navController: NavController
    private val category = CategoryProvide.Base()

    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentExplorerBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.txtViewAll.setOnClickListener { findNavController().navigate(R.id.viewAllFragment) }
        navControllerSetup()
    }

    override fun onStart() {
        super.onStart()
        categorySetup()
        navController.navigate(R.id.action_global_phonesFragment)
    }

    private fun navControllerSetup() {
        val navHostFragment =
            childFragmentManager.findFragmentById(R.id.explorer_nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
    }

    private fun categorySetup() {
        mBinding.explRv.layoutManager =
            LinearLayoutManager(requireActivity(), RecyclerView.HORIZONTAL, false)
        val adapter = ExplorerAdapter(this, TextColorProvider.Base(requireActivity()))
        mBinding.explRv.adapter = adapter
        adapter.setData(category.default(), category.selected())
        mBinding.explRv.adapter = adapter
        mBinding.explRv.smoothScrollToPosition(0)
    }

    override fun click(position: Int) {
        CategoryNavigate.Base().navigate(navController, position = position)
    }
}