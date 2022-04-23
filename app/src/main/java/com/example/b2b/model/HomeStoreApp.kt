package com.example.b2b.model
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HomeStoreApp(
    val id: Int,
    val is_buy: Boolean,
    val is_new: Boolean,
    val picture: String,
    val subtitle: String,
    val title: String
) : Parcelable