package com.example.projectwerk.data.remote

class SfeerRemoteDataSource (val apiService: GhentApiService): BaseDataSource(){
    suspend fun getsfeers() = getResult{apiService.getSfeer()}

}