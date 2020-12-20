package com.example.projectwerk.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projectwerk.models.Sfeer


class SfeerDetailViewModel : ViewModel() {
    private var _sfeer = MutableLiveData<Sfeer>()
    val sfeer: LiveData<Sfeer>
        get() = _sfeer

    fun updateSfeer(sfeer: Sfeer){
        _sfeer.value = sfeer
    }
}