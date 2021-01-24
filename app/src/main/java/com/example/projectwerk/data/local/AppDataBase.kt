package com.example.projectwerk.data.local;

import android.content.Context
import androidx.room.Database
import androidx.room.Room;
import androidx.room.RoomDatabase
import com.example.projectwerk.models.Sfeer
import com.example.projectwerk.models.SfeerFields

@Database(entities =[SfeerEntity::class, SfeerFieldsEntity::class],version = 6,exportSchema = false)
abstract class AppDataBase:RoomDatabase() {

    abstract fun sfeerDao(): SfeerDao
    abstract fun sfeerFieldsDao(): SfeerFieldsDao

    companion object{
        @Volatile private var instance: AppDataBase? = null

        fun getDatabase(context: Context) : AppDataBase =
        instance ?: synchronized(this){instance ?: BuildDatabase(context).also{instance =it}}

        private fun BuildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, AppDataBase::class.java,"sfeerDB")
        .fallbackToDestructiveMigration()
        .build()


    }
}
