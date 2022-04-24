package com.example.b2b.adapters.phonesFragmentAdapter

import android.content.Context
import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.b2b.R
import com.example.b2b.databinding.BestSellerItemRawBinding
import com.example.b2b.model.BestSellerApp
import com.example.b2b.utils.LoadImage
import com.example.b2b.utils.ResourceProvider

class BestSellerAdapter(
    private val listBestSellerApp: List<BestSellerApp>,
    private val loadImage: LoadImage,
    private val resourceProvider: ResourceProvider
) :
    RecyclerView.Adapter<BestSellerAdapter.BsHolder>() {
    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BsHolder {
        mContext = parent.context
        val view = BestSellerItemRawBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return BsHolder(view)
    }

    override fun onBindViewHolder(holder: BsHolder, position: Int) {
        loadImage.load(holder.view.bsPicture, listBestSellerApp[position].picture)

        if (listBestSellerApp[position].is_favorites)
            holder.view.bsIsFavorites.setImageResource(R.drawable.ic_favorite_true)
        holder.view.bsDiscountPrice.text =
            addDollarSign(listBestSellerApp[position].discount_price.toString())
        holder.view.bsPriceWithoutDiscount.text =
            addDollarSign(listBestSellerApp[position].price_without_discount.toString())
        holder.view.bsTitle.text = listBestSellerApp[position].title
    }

    override fun getItemCount(): Int = listBestSellerApp.size

    class BsHolder(val view: BestSellerItemRawBinding) : RecyclerView.ViewHolder(view.root) {
        val priceWithoutDiscount = view.bsPriceWithoutDiscount.also {
            it.paintFlags = STRIKE_THRU_TEXT_FLAG
        }
    }

    private fun addDollarSign(positionString: String): String =
        resourceProvider.getString(
            mContext,
            R.string.dollar_sign
        ) + positionString
}


