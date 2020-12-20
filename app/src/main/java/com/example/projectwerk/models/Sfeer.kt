package com.example.projectwerk.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Sfeer(
    val recordid: String,
    val fields: SfeerFields
) : Parcelable
