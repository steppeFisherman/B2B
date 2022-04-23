package com.example.data.repository

import com.example.data.storage.cloudModel.BestSellerCloud
import com.example.data.storage.cloudModel.DataCloud
import com.example.data.storage.cloudModel.HomeStoreCloud
import com.example.domain.models.BestSellerDomain
import com.example.domain.models.DataDomain
import com.example.domain.models.HomeStoreDomain

interface MapCloudToDomain {

    fun mapCloudToDomainBestSeller(cloudBestSeller: BestSellerCloud): BestSellerDomain
    fun mapCloudToDomainHomeStore(cloudHomeStore: HomeStoreCloud): HomeStoreDomain
    fun mapCloudToDomainData(dataCloud: DataCloud): DataDomain

    class Base : MapCloudToDomain {
        override fun mapCloudToDomainBestSeller(cloudBestSeller: BestSellerCloud)
                : BestSellerDomain {
            return BestSellerDomain(
                discount_price = cloudBestSeller.price_without_discount,
                id = cloudBestSeller.id,
                is_favorites = cloudBestSeller.is_favorites,
                picture = cloudBestSeller.picture,
                price_without_discount = cloudBestSeller.discount_price,
                title = cloudBestSeller.title
            )
        }

        override fun mapCloudToDomainHomeStore(cloudHomeStore: HomeStoreCloud)
                : HomeStoreDomain {
            return HomeStoreDomain(
                id = cloudHomeStore.id,
                is_buy = cloudHomeStore.is_buy,
                is_new = cloudHomeStore.is_new,
                picture = cloudHomeStore.picture,
                subtitle = cloudHomeStore.subtitle,
                title = cloudHomeStore.title
            )
        }

        override fun mapCloudToDomainData(dataCloud: DataCloud): DataDomain {
            return DataDomain(
                best_seller = listMapCloudToDomainBestSeller(dataCloud.best_seller),
                home_store = listMapCloudToDomainHomeStore(dataCloud.home_store)
            )
        }

        private fun listMapCloudToDomainBestSeller(list: List<BestSellerCloud>)
                : List<BestSellerDomain> {
            return list.map { cloudBestSeller ->
                mapCloudToDomainBestSeller(cloudBestSeller)
            }
        }

        private fun listMapCloudToDomainHomeStore(list: List<HomeStoreCloud>)
                : List<HomeStoreDomain> {
            return list.map { cloudHomeStore ->
                mapCloudToDomainHomeStore(cloudHomeStore)
            }
        }
    }
}