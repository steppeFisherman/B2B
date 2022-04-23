package com.example.data.repository

import com.example.data.storage.cacheModel.BestSellerCache
import com.example.data.storage.cacheModel.DataCache
import com.example.data.storage.cacheModel.HomeStoreCache
import com.example.data.storage.cloudModel.BestSellerCloud
import com.example.data.storage.cloudModel.DataCloud
import com.example.data.storage.cloudModel.HomeStoreCloud

interface MapCloudToCache {

    fun mapCloudToCacheBestSeller(cloudBestSeller: BestSellerCloud): BestSellerCache
    fun mapCloudToCacheHomeStore(cloudHomeStore: HomeStoreCloud): HomeStoreCache
    fun mapCloudToCacheData(dataCloud: DataCloud): DataCache

    class Base : MapCloudToCache {

        override fun mapCloudToCacheBestSeller(cloudBestSeller: BestSellerCloud)
                : BestSellerCache {
            return BestSellerCache(
                discount_price = cloudBestSeller.price_without_discount,
                id = cloudBestSeller.id,
                is_favorites = cloudBestSeller.is_favorites,
                picture = cloudBestSeller.picture,
                price_without_discount = cloudBestSeller.discount_price,
                title = cloudBestSeller.title
            )
        }

        override fun mapCloudToCacheHomeStore(cloudHomeStore: HomeStoreCloud)
                : HomeStoreCache {
            return HomeStoreCache(
                id = cloudHomeStore.id,
                is_buy = cloudHomeStore.is_buy,
                is_new = cloudHomeStore.is_new,
                picture = cloudHomeStore.picture,
                subtitle = cloudHomeStore.subtitle,
                title = cloudHomeStore.title
            )
        }

        override fun mapCloudToCacheData(dataCloud: DataCloud): DataCache {
            return DataCache(
                _id = 0,
                best_seller = listMapCloudToCacheBestSeller(dataCloud.best_seller),
                home_store = listMapCloudToCacheHomeStore(dataCloud.home_store)
            )
        }

        private fun listMapCloudToCacheBestSeller(list: List<BestSellerCloud>): List<BestSellerCache> {
            return list.map { cloudBestSeller ->
                mapCloudToCacheBestSeller(cloudBestSeller)
            }
        }

        private fun listMapCloudToCacheHomeStore(list: List<HomeStoreCloud>): List<HomeStoreCache> {
            return list.map { cloudHomeStore ->
                mapCloudToCacheHomeStore(cloudHomeStore)
            }
        }
    }
}


