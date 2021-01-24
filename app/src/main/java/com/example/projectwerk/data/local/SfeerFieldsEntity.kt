package com.example.projectwerk.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName ="sfeerFields", foreignKeys = arrayOf(
    ForeignKey(
        entity = SfeerEntity::class,
        parentColumns = arrayOf("recordid"),
        childColumns = arrayOf("sfeerid"),
        onDelete = ForeignKey.CASCADE
    )
))
class SfeerFieldsEntity (
        val timestamp: String? ="",
        val customername: String? ="",
        val description: String? ="",
        val total_override: Int? =0,
        val th1: Int? =0,
        val th2: Int? =0,
        val th3: Int? =0,
    @ColumnInfo(name="sfeerid", index = true)
    var sfeerid: String? = ""
){
    @PrimaryKey(autoGenerate = true)
    var id: Int =0
}