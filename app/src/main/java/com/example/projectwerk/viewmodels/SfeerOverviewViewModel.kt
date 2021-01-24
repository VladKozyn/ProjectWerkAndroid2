package com.example.projectwerk.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectwerk.data.remote.GhentApiService
import com.example.projectwerk.models.Sfeer
import com.example.projectwerk.repos.SfeerRepository
import kotlinx.coroutines.launch


class SfeerOverviewViewModel( repository: SfeerRepository) : ViewModel() {
    val sfeers = repository.getSfeers()

   /* private var _sfeers = MutableLiveData<List<Sfeer>>()
    val sfeer: LiveData<List<Sfeer>>
        get() = _sfeers


    init {
        getSfeer()
    }

    private fun getSfeer() {
        viewModelScope.launch {
            try {
                val response = apiService.getSfeer();
                _sfeers.value = response.records
            } catch (e: Exception) {
                Log.e("Error api ", e.message, e)
            }
        }
    }*/

}