package com.example.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.data.net.CloudData
import com.example.data.storage.room.AppRoomDao
import com.example.domain.models.DataDomain
import com.example.domain.models.ErrorType
import com.example.domain.models.Result
import com.example.domain.repository.Repository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import java.net.UnknownHostException
import javax.inject.Singleton

@Singleton
class RepositoryImpl(
    private val appDao: AppRoomDao,
    private val mapperCacheToDomain: MapCacheToDomain,
    private val mapperCloudToCache: MapCloudToCache,
    private val cloudData: CloudData,
    private val dispatchers: ToDispatch,
) : Repository {

    private val exceptionHandler = CoroutineExceptionHandler { _, _ -> }
    private val scope = CoroutineScope(Job() + exceptionHandler)

    override val allItems: Result
        get() = try {
            Result.Success(fetchFromCloud())
        } catch (e: Exception) {
            Result.Fail(
                when (e) {
                    is UnknownHostException -> ErrorType.NO_CONNECTION
                    is NullPointerException -> ErrorType.NULL_POINTER_EXCEPTION
                    else -> ErrorType.GENERIC_ERROR
                }
            )
        }

    private fun fetchFromCloud(): MutableLiveData<List<DataDomain>> {
        val item = MutableLiveData<List<DataDomain>>()
        dispatchers.launchIO(scope = scope) {
            val cacheList = appDao.getItemsBySuspend()
            if (cacheList.isNullOrEmpty()) {
                val cloud = cloudData.fetchCloud()
                val cache = mapperCloudToCache.mapCloudToCacheData(cloud)
                appDao.insertItem(cache)
                dispatchers.launchUI(this) {
                    item.value = listOf(mapperCacheToDomain.mapCacheToDomainData(cache))
                }
            } else {
                dispatchers.launchUI(this) {
                    item.value = cacheList.map { dataCache ->
                        mapperCacheToDomain.mapCacheToDomainData(dataCache)
                    }
                }
            }
        }
        return item
    }
}





