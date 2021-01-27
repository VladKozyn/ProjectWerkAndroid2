package com.example.projectwerk.data.local

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SfeerDao {

    @Transaction
    @Query("select * from  sfeer")
    fun getAllSfeers(): LiveData<List<SfeerAndFields>>

    @Transaction
    @Query("select * from  sfeer where recordid=:id")
    fun getSfeer(id:String): LiveData<SfeerAndFields>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<SfeerEntity>)
}