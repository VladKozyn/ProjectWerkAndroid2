package com.example.projectwerk.data.local;

import androidx.room.Room;

abstract class AppDataBase: RoomDatabase() {


    companion object{
@volatile private var instance: AppDataBase = null
           fun getDatabase(context: Context) AppDataBase =
                instance ?: synchronized (this){instance ?: buildDatabase(context).also{instance =it}}

                private fun BuildDatabase(appContext: Context) =
        Room.databaseBuilder(appContext, AppDataBase:::class.java, "SfeerDB").fallbackToDestructiveMigration().build()


    }
}
