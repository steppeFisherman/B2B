package com.example.data.storage.room

import androidx.room.TypeConverter
import com.example.data.storage.cacheModel.BestSellerCache
import com.example.data.storage.cacheModel.HomeStoreCache
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ConverterKlass {

    @TypeConverter
    fun fromBestSellerCacheList(value: List<BestSellerCache>): String {
        val gson = Gson()
        val type = object : TypeToken<List<BestSellerCache>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toBestSellerCacheList(value: String): List<BestSellerCache> {
        val gson = Gson()
        val type = object : TypeToken<List<BestSellerCache>>() {}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun fromHomeStoreCacheList(value: List<HomeStoreCache>): String {
        val gson = Gson()
        val type = object : TypeToken<List<HomeStoreCache>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toHomeStoreCacheList(value: String): List<HomeStoreCache> {
        val gson = Gson()
        val type = object : TypeToken<List<HomeStoreCache>>() {}.type
        return gson.fromJson(value, type)
    }
}
