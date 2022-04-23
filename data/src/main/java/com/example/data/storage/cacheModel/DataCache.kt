package com.example.data.storage.cacheModel

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "main_table")
data class DataCache(
    @PrimaryKey(autoGenerate = true)
    val _id: Int,
    val best_seller: List<BestSellerCache>,
    val home_store: List<HomeStoreCache>
)

