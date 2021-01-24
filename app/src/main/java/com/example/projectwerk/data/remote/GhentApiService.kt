package com.example.projectwerk.data.remote


import androidx.multidex.BuildConfig
import com.example.projectwerk.models.GetApiResponse
import com.example.projectwerk.utils.Resource
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://data.stad.gent/"

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
private val interceptor = HttpLoggingInterceptor()
    .setLevel(
        if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
        else HttpLoggingInterceptor.Level.NONE
    )

private val client = OkHttpClient.Builder()
    .addInterceptor(interceptor)
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .client(client)
    .build()


interface GhentApiService {
    @GET("api/records/1.0/search/?dataset=proximus-drukte-info-geografisch-gent&q=&facet=description")
    suspend fun getSfeer(): Response<GetApiResponse>
}

object GhentApi {
    val apiService: GhentApiService by lazy { retrofit.create(GhentApiService::class.java) }
}