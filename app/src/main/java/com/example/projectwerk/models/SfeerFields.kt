package com.example.projectwerk.models

import android.os.Parcelable
import com.example.projectwerk.data.local.SfeerEntity
import com.example.projectwerk.data.local.SfeerFieldsEntity
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SfeerFields(
    val timestamp: String ="",
        val customername: String? ="",
        val description: String? ="",
            val total_override: Int? =0,
            val th1: Int? =0,
            val th2: Int? =0,
            val th3: Int? =0,

        ) : Parcelable{
        fun toDatabaseModel(sfeerid : String?): SfeerFieldsEntity {
            return SfeerFieldsEntity(timestamp, customername,description,total_override, th1,th2,th3,sfeerid )
            //TimeStamp, customername,description,total_override, th1,th2,th3,sfeerid
        }
    }
