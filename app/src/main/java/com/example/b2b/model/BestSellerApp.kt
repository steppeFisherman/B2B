package com.example.b2b.model
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BestSellerApp(
    val discount_price: Int,
    val id: Int,
    val is_favorites: Boolean,
    val picture: String,
    val price_without_discount: Int,
    val title: String
) : Parcelable