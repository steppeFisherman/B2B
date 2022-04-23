package com.example.ecommerceconcept.adapters.phonesFragmentAdapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.b2b.R
import com.example.b2b.databinding.PhonesFragmentRvBinding
import com.example.b2b.model.BestSellerApp
import com.example.b2b.model.DataApp
import com.example.b2b.model.HomeStoreApp
import com.example.b2b.utils.BestSellerAppProvider
import com.example.b2b.utils.LoadImage
import com.example.b2b.utils.ResourceProvider
import com.example.b2b.utils.getString


class PhonesFragmentAdapter : RecyclerView.Adapter<PhonesFragmentAdapter.PhonesHolder>() {
    private var mListHomeStoreApp = emptyList<HomeStoreApp>()
    private var mListBestSellerApp = emptyList<BestSellerApp>()
    private var data = BestSellerAppProvider.Base()
    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhonesHolder {
        mContext = parent.context
        val view = PhonesFragmentRvBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return PhonesHolder(view)
    }

    override fun onBindViewHolder(holder: PhonesHolder, position: Int) {
        if (position == 0) {
            holder.view.headText.text = getString(mContext, R.string.hot_sales)
            setHotSalesAdapter(holder.view.mainAdapterRv)

        } else if (position == 1) {
            holder.view.headText.text = getString(mContext, R.string.best_seller)
            setBestSellerAdapter(holder.view.mainAdapterRv, mListBestSellerApp)
        }
    }

    override fun getItemCount(): Int = mListHomeStoreApp.size

    class PhonesHolder(val view: PhonesFragmentRvBinding) : RecyclerView.ViewHolder(view.root)

    private fun setHotSalesAdapter(recyclerView: RecyclerView) {
        val hotSalesAdapter = HotSalesAdapter(mListHomeStoreApp, LoadImage.Base())
        recyclerView.layoutManager =
            LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false)
        recyclerView.adapter = hotSalesAdapter
    }

    private fun setBestSellerAdapter(recyclerView: RecyclerView, list: List<BestSellerApp>) {
        /**
        just for the test purpose, to check the recyclerview scroll...two lines below
        should be deleted later
         */
        val mList = list.toMutableList()
        mList.addAll(data.provide())

        val bestSellerAdapter = BestSellerAdapter(
            mList,
            loadImage = LoadImage.Base(),
            resourceProvider = ResourceProvider.Base()
        )
        recyclerView.layoutManager = GridLayoutManager(mContext, 2)
        recyclerView.adapter = bestSellerAdapter
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: List<DataApp>) {
        mListHomeStoreApp = list[0].home_store
        mListBestSellerApp = list[0].best_seller
        notifyDataSetChanged()
    }
}


