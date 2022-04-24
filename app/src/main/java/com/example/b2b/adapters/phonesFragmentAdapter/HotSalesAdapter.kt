package com.example.b2b.adapters.phonesFragmentAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.b2b.databinding.HomeStoreItemRawBinding
import com.example.b2b.model.HomeStoreApp
import com.example.b2b.utils.LoadImage

class HotSalesAdapter(
    private val listHomeStoreApp: List<HomeStoreApp>,
    private val loadImage: LoadImage
) :
    RecyclerView.Adapter<HotSalesAdapter.HsHolder>() {
    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HsHolder {
        mContext = parent.context
        val view = HomeStoreItemRawBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return HsHolder(view)
    }

    override fun onBindViewHolder(holder: HsHolder, position: Int) {
        loadImage.load(holder.view.hsPicture, listHomeStoreApp[position].picture)

        if (!listHomeStoreApp[position].is_new)
            holder.view.hsIsNew.visibility = View.GONE

        holder.view.hsTitle.text = listHomeStoreApp[position].title
        holder.view.hsSubtitle.text = listHomeStoreApp[position].subtitle
    }

    override fun getItemCount(): Int = listHomeStoreApp.size

    class HsHolder(val view: HomeStoreItemRawBinding) : RecyclerView.ViewHolder(view.root)
}


