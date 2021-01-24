package com.example.projectwerk.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import kotlinx.coroutines.Dispatchers

fun<T,A> performGetOperation(
    databaseQuery: ()->LiveData<T>,
    networkCall: suspend ()->Resource<A>,
    saveCallResult: suspend(A) ->Unit
): LiveData<Resource<T>> =
    liveData (Dispatchers.IO) {
        emit(Resource.loading())
        val source = databaseQuery.invoke().map{Resource.success(it) }
        emitSource(source)

        val responseStatus = networkCall.invoke()
        if(responseStatus.status == Status.SUCCESS){
            saveCallResult(responseStatus.data!!)
            }else if (responseStatus.status == Status.ERROR){
                emit(Resource.error(responseStatus.message!!))
            emitSource(source)
        }

    }

/*
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import kotlinx.coroutines.Dispatchers

//offline cashing voorzien
//eest data ophalen met api call
//de response (data) opslaan in u database
//en daarna terug geven wat er in database staat

//single source of truth = meest recente data
//ENKEL VOOR GET CALLS
 fun<T,A> performGetOperation(
    databaseQuery:()-> LiveData<T>, //de query van je database, scholenDao
    networkCall: suspend ()-> Resource<A>,//api server.getScholen
    saveCallResult: suspend (A) -> Unit //insert methode om op te slaan

): LiveData<Resource<T>> =
    liveData(Dispatchers.IO){
        emit(Resource.loading()) //zet status
        val source = databaseQuery.invoke().map { Resource.success(it) }
        emitSource(source)

        val responseStatus = networkCall.invoke() //netwerk call
        //als gelukt: geef data mee
        if(responseStatus.status == Status.SUCCESS){
            saveCallResult(responseStatus.data!!) //opslaan in db en terug geven
          }
        //als niet gelukt: geef error mee
        else if(responseStatus.status == Status.ERROR){
            emit(Resource.error(responseStatus.message !!))
            emitSource(source)

        }
    }

 */