package com.example.projectwerk.models

import android.os.Parcelable
import com.example.projectwerk.data.local.SfeerEntity
import com.example.projectwerk.data.local.SfeerFieldsEntity
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SfeerFields(
    val TimeStamp: String,
    val customername: String,
    val description: String,
    val total_override: String,
    val th1: Int,
    val th2: Int,
    val th3: Int,

    ) : Parcelable{
    fun toDatabaseModel(sfeerId : String): SfeerFieldsEntity {
        return SfeerFieldsEntity(TimeStamp, customername,description,total_override, th1,th2,th3,sfeerId )
    }
}
