package com.example.projectwerk.data.local

import androidx.room.Embedded
import androidx.room.Relation

class SfeerAndFields (

    @Embedded
    val Sfeer: SfeerEntity,
            @Relation(parentColumn = "recordid", entityColumn = "sfeerId")
            val fields: SfeerFieldsEntity

    )