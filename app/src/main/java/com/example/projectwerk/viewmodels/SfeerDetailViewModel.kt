package com.example.projectwerk.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.projectwerk.data.local.SfeerAndFields
import com.example.projectwerk.repos.SfeerRepository


class SfeerDetailViewModel(private val repository: SfeerRepository) : ViewModel() {
    private lateinit var _sfeer: LiveData<SfeerAndFields>
    val sfeer: LiveData<SfeerAndFields>
        get() = _sfeer

    fun updateSfeer(id: String){
        _sfeer = repository.getSfeer(id)
    }
}