package com.example.projectwerk.repos

import android.content.Context
import com.example.projectwerk.data.local.AppDataBase
import com.example.projectwerk.data.local.SfeerLocalDataSource
import com.example.projectwerk.data.remote.GhentApi
import com.example.projectwerk.data.remote.SfeerRemoteDataSource

class RepositoryUtils {
    companion object{
        fun createSfeerRepository(context: Context): SfeerRepository{
            val database = AppDataBase.getDatabase(context)
            val localDataSource = SfeerLocalDataSource(database.sfeerDao(), database.sfeerFieldsDao())
            val remoteDataSource= SfeerRemoteDataSource(GhentApi.apiService)

            return SfeerRepository(localDataSource,remoteDataSource)
        }
    }
}