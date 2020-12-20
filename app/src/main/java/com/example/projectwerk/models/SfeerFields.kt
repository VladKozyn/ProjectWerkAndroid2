package com.example.projectwerk.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SfeerFields(
    val naam: String,
    val adres: String,
    val gemeente: String,
    val email: String = " "
    ) : Parcelable
