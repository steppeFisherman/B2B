package com.example.b2b.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.b2b.databinding.MainActivityItemRawBinding
import com.example.b2b.model.Category
import com.example.ecommerceconcept.adapters.MainDiffUtil
import com.example.b2b.utils.TextColorProvider

class MainActivityAdapter(
    private val onClick: OnClick,
    private val textColorProvider: TextColorProvider
) :
    RecyclerView.Adapter<MainActivityAdapter.MainHolder>() {

    private var mList = emptyList<Category>()
    private var mListSelected = emptyList<Category>()
    private var positionIndex = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val view = MainActivityItemRawBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return MainHolder(view)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: MainHolder, position: Int) {

        holder.binding.apply {
            categoryImg.setImageResource(mList[position].categoryImage)
            categoryTxt.text = mList[position].categoryName
        }

        holder.binding.categoryImg.setOnClickListener {
            positionIndex = holder.adapterPosition
            notifyDataSetChanged()
            onClick.click(positionIndex)
        }

        if (positionIndex == position) {
            holder.binding.apply {
                categoryImg.setImageResource(mListSelected[position].categoryImage)
                categoryTxt.setTextColor(textColorProvider.selected())
            }
        } else {
            holder.binding.apply {
                categoryImg.setImageResource(mList[position].categoryImage)
                categoryTxt.setTextColor(textColorProvider.default())
            }
        }
    }

    override fun getItemCount() = mList.size

    class MainHolder(val binding: MainActivityItemRawBinding) :
        RecyclerView.ViewHolder(binding.root)

    fun setData(newList: List<Category>, listSelected: List<Category>) {
        val diffUtil = MainDiffUtil(mList, newList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        mList = newList
        mListSelected = listSelected
        diffResult.dispatchUpdatesTo(this)
    }

    interface OnClick {
        fun click(position: Int)
    }
}