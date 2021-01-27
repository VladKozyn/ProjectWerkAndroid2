package com.example.projectwerk.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName ="sfeer")
class SfeerEntity (
@PrimaryKey
//@ColumnInfo(name = "recordid")
val recordid: String
)