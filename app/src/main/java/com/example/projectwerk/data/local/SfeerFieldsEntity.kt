package com.example.projectwerk.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.projectwerk.models.SfeerFields

@Entity(tableName ="sfeerFields", foreignKeys = arrayOf(
    ForeignKey(
        entity = SfeerEntity::class,
        parentColumns = arrayOf("recordid"),
        childColumns = arrayOf("sfeerId"),
        onDelete = ForeignKey.CASCADE
    )
))
class SfeerFieldsEntity (
    val TimeStamp: String,
    val customername: String,
    val description: String,
    val total_override: String,
    val th1: Int,
    val th2: Int,
    val th3: Int,
    @ColumnInfo(name="parkingId", index = true)
    var sfeerId: String?
){
    @PrimaryKey(autoGenerate = true)
    var id: Int =0
}