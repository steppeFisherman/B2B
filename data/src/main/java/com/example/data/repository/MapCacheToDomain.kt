package com.example.data.repository

import com.example.data.storage.cacheModel.BestSellerCache
import com.example.data.storage.cacheModel.DataCache
import com.example.data.storage.cacheModel.HomeStoreCache
import com.example.domain.models.BestSellerDomain
import com.example.domain.models.DataDomain
import com.example.domain.models.HomeStoreDomain

interface MapCacheToDomain {

    fun mapCacheToDomainBestSeller(cacheBestSeller: BestSellerCache): BestSellerDomain
    fun mapCacheToDomainHomeStore(cacheHomeStore: HomeStoreCache): HomeStoreDomain
    fun mapCacheToDomainData(dataCache: DataCache): DataDomain

    class Base : MapCacheToDomain {
        override fun mapCacheToDomainBestSeller(cacheBestSeller: BestSellerCache)
                : BestSellerDomain {
            return BestSellerDomain(
                discount_price = cacheBestSeller.discount_price,
                id = cacheBestSeller.id,
                is_favorites = cacheBestSeller.is_favorites,
                picture = cacheBestSeller.picture,
                price_without_discount = cacheBestSeller.price_without_discount,
                title = cacheBestSeller.title
            )
        }

        override fun mapCacheToDomainHomeStore(cacheHomeStore: HomeStoreCache)
                : HomeStoreDomain {
            return HomeStoreDomain(
                id = cacheHomeStore.id,
                is_buy = cacheHomeStore.is_buy,
                is_new = cacheHomeStore.is_new,
                picture = cacheHomeStore.picture,
                subtitle = cacheHomeStore.subtitle,
                title = cacheHomeStore.title
            )
        }

        override fun mapCacheToDomainData(dataCache: DataCache): DataDomain {
            return DataDomain(
                best_seller = listMapCacheToDomainBestSeller(dataCache.best_seller),
                home_store = listMapCacheToDomainHomeStore(dataCache.home_store)
            )
        }

        private fun listMapCacheToDomainBestSeller(list: List<BestSellerCache>)
                : List<BestSellerDomain> {
            return list.map { cacheBestSeller ->
                mapCacheToDomainBestSeller(cacheBestSeller)
            }
        }

        private fun listMapCacheToDomainHomeStore(list: List<HomeStoreCache>): List<HomeStoreDomain> {
            return list.map { cacheHomeStore ->
                mapCacheToDomainHomeStore(cacheHomeStore)
            }
        }
    }
}