package com.example.projectwerk.data.local

import androidx.room.Embedded
import androidx.room.Relation

data class SfeerAndFields (

    @Embedded
    val Sfeer: SfeerEntity,

    @Relation(parentColumn = "recordid", entityColumn = "sfeerid")
    val fields: SfeerFieldsEntity?

    )