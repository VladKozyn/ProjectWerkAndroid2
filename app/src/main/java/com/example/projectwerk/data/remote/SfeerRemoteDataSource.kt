package com.example.projectwerk.data.remote

import com.example.projectwerk.data.BaseDateSource

class SfeerRemoteDataSource (val apiService: GhentApiService): BaseDateSource(){

    suspend fun getsfeers() = getResult{apiService.getSfeer()}

}