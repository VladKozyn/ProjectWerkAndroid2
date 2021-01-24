package com.example.projectwerk.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface SfeerFieldsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<SfeerFieldsEntity>)
}