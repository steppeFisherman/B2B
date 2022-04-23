package com.example.b2b.screens.explorerFragment.phones

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.b2b.R
import com.example.b2b.databinding.FragmentPhonesBinding
import com.example.b2b.screens.BaseFragment
import com.example.b2b.utils.ShowSnack
import com.example.ecommerceconcept.adapters.phonesFragmentAdapter.PhonesFragmentAdapter
import com.example.b2b.utils.showSnackLong
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhonesFragment : BaseFragment<FragmentPhonesBinding>() {

    private val vm by viewModels<PhonesFragmentViewModel>()
    private var mAdapter: PhonesFragmentAdapter = PhonesFragmentAdapter()

    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentPhonesBinding.inflate(inflater, container, false)

    override fun onStart() {
        super.onStart()
        sendDataToAdapter()
    }

    private fun sendDataToAdapter() {
        mBinding.phonesFragmentRv.adapter = mAdapter

        vm.allItems.observe(viewLifecycleOwner) { listDataApp ->
            listDataApp?.let { mAdapter.setData(it) }
        }

        vm.error.observe(viewLifecycleOwner) {
            when (it.ordinal) {
                0 -> view?.showSnackLong(R.string.no_connection_message)
                1 -> (requireActivity() as ShowSnack).showToast(R.string.null_pointer_exception)
                2 -> view?.showSnackLong(R.string.something_went_wrong)
            }
        }
    }
}