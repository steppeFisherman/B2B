package com.example.b2b.screens.explorerFragment.viewall

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.example.b2b.databinding.FragmentViewAllBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_EXPANDED
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ViewAllFragment : BottomSheetDialogFragment() {

    private var binding: FragmentViewAllBinding? = null
    private val mBinding get() = binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentViewAllBinding.inflate(layoutInflater, container, false)
        mBinding.closeBtn.setOnClickListener { this.dismiss() }
        return mBinding.root
    }

    override fun onStart() {
        (super.onStart())
        dialog?.let {
            val bottomSheet =
                it.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
                        as FrameLayout
            BottomSheetBehavior.from(bottomSheet).state = STATE_EXPANDED
        }
        provideFilterOptions()
    }

    private fun provideFilterOptions() {
        val adapter = FilterOptions.Base(requireActivity()).provide()
        mBinding.phonesAutocompleteTxt.setAdapter(adapter[0])
        mBinding.priceAutocompleteTxt.setAdapter(adapter[1])
        mBinding.sizeAutocompleteTxt.setAdapter(adapter[2])
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}