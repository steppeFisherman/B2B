package com.example.b2b.model
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataApp(
    val best_seller: List<BestSellerApp>,
    val home_store: List<HomeStoreApp>
) : Parcelable