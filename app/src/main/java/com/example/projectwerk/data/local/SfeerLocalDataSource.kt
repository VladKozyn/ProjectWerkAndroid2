package com.example.projectwerk.data.local

import com.example.projectwerk.models.Sfeer

class SfeerLocalDataSource(private val sfeerDao: SfeerDao, private var sfeerFieldsDao: SfeerFieldsDao) {
    fun getSfeers() = sfeerDao.getAllSfeers()
    fun getSfeer(id:String) = sfeerDao.getParking(id)
    fun saveSfeers(list:List<Sfeer>){
        val sfeerList = ArrayList<SfeerEntity>()
        list.forEach{
            sfeer -> sfeerList.add(sfeer.toDatabaseModel())

        }
        sfeerDao.insertAll(sfeerList)

        val fieldsList = ArrayList<SfeerFieldsEntity>()
        list.forEach{ sfeer -> fieldsList.add(sfeer.fields.toDatabaseModel(sfeer.recordid))
        sfeerFieldsDao.insertAll(fieldsList)
        }
    }
}