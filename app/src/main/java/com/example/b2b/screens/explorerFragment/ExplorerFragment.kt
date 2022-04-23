package com.example.b2b.screens.explorerFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.b2b.databinding.FragmentExplorerBinding
import com.example.b2b.screens.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExplorerFragment : BaseFragment<FragmentExplorerBinding>() {

//    private val category = CategoryProvider.Base()

    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentExplorerBinding.inflate(inflater, container, false)

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        mBinding.txtViewAll.setOnClickListener { findNavController().navigate(R.id.viewAllFragment) }
//        mBinding.mainActivityRv.layoutManager =
//            LinearLayoutManager(requireActivity(), RecyclerView.HORIZONTAL, false)
//        val adapter = MainActivityAdapter(this, TextColorProvider.Base(requireActivity()))
//        mBinding.mainActivityRv.adapter = adapter
//        adapter.setData(category.provideCategories(), category.provideCategoriesSelected())
//    }
//
//    override fun click(position: Int) {
//                    when (position) {
//                0 -> findNavController().navigate(R.id.action_global_phonesFragment)
//                1 -> findNavController().navigate(R.id.action_global_computerFragment)
//                2 -> findNavController().navigate(R.id.action_global_healthFragment)
//                3 -> findNavController().navigate(R.id.action_global_booksFragment)
//                4 -> findNavController().navigate(R.id.action_global_othersFragment)
//                5 -> findNavController().navigate(R.id.action_global_othersTwoFragment)
//                6 -> findNavController().navigate(R.id.action_global_othersThreeFragment)
//            }
//    }
}