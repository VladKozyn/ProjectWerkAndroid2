package com.example.projectwerk.models

import android.os.Parcelable
import com.example.projectwerk.data.local.SfeerEntity
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Sfeer(
    val recordid: String,
    val fields: SfeerFields
) : Parcelable{
    fun toDatabaseModel(): SfeerEntity{
        return SfeerEntity(recordid)
    }
}
