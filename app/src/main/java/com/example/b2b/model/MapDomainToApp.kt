package com.example.b2b.model

import com.example.domain.models.BestSellerDomain
import com.example.domain.models.DataDomain
import com.example.domain.models.HomeStoreDomain

interface MapDomainToApp {

    fun mapDomainToAppBestSeller(domainBestSeller: BestSellerDomain): BestSellerApp
    fun mapDomainToAppHomeStore(domainHomeStore: HomeStoreDomain): HomeStoreApp
    fun mapDomainToAppData(dataDomain: DataDomain): DataApp

    class BaseMapDomainToApp : MapDomainToApp {
        override fun mapDomainToAppBestSeller(domainBestSeller: BestSellerDomain): BestSellerApp {
            return BestSellerApp(
                discount_price = domainBestSeller.discount_price,
                id = domainBestSeller.id,
                is_favorites = domainBestSeller.is_favorites,
                picture = domainBestSeller.picture,
                price_without_discount = domainBestSeller.price_without_discount,
                title = domainBestSeller.title
            )
        }

        override fun mapDomainToAppHomeStore(domainHomeStore: HomeStoreDomain): HomeStoreApp {
            return HomeStoreApp(
                id = domainHomeStore.id,
                is_buy = domainHomeStore.is_buy,
                is_new = domainHomeStore.is_new,
                picture = domainHomeStore.picture,
                subtitle = domainHomeStore.subtitle,
                title = domainHomeStore.title
            )
        }

        override fun mapDomainToAppData(dataDomain: DataDomain): DataApp {
            return DataApp(
                best_seller = listMapDomainToAppBestSeller(dataDomain.best_seller),
                home_store = listMapDomainToAppHomeStore(dataDomain.home_store)
            )
        }

        private fun listMapDomainToAppBestSeller(list: List<BestSellerDomain>)
                : List<BestSellerApp> {
            return list.map { domainBestSeller ->
                mapDomainToAppBestSeller(domainBestSeller)
            }
        }

        private fun listMapDomainToAppHomeStore(list: List<HomeStoreDomain>)
                : List<HomeStoreApp> {
            return list.map { domainHomeStore ->
                mapDomainToAppHomeStore(domainHomeStore)
            }
        }
    }
}