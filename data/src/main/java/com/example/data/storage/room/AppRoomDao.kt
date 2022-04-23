package com.example.data.storage.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.storage.cacheModel.DataCache

@Dao
interface AppRoomDao {

    @Query("SELECT * FROM main_table")
    fun fetchAllItems(): LiveData<List<DataCache>>

    @Query("SELECT * FROM main_table")
    suspend fun getItemsBySuspend(): List<DataCache>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(dataCache: DataCache)

}