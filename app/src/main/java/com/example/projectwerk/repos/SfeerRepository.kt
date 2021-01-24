package com.example.projectwerk.repos

import com.example.projectwerk.data.local.SfeerLocalDataSource
import com.example.projectwerk.data.remote.SfeerRemoteDataSource
import com.example.projectwerk.utils.performGetOperation

class SfeerRepository(
    private val sfeerLocalDataSource: SfeerLocalDataSource,
    private val sfeerRemoteDataSource: SfeerRemoteDataSource
)
{
    fun getSfeer(id:String) = sfeerLocalDataSource.getSfeer(id)

    fun getSfeers() = performGetOperation(
        databaseQuery = {sfeerLocalDataSource.getSfeers()},
        networkCall = {sfeerRemoteDataSource.getsfeers()},
        saveCallResult = {sfeerLocalDataSource.saveSfeers(it.records)}
    )
}