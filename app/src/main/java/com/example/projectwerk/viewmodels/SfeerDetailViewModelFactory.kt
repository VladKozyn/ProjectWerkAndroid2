package com.example.projectwerk.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.projectwerk.data.remote.GhentApiService
import com.example.projectwerk.repos.SfeerRepository


class SfeerDetailViewModelFactory(private val repository: SfeerRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(SfeerDetailViewModel::class.java)) {

            return SfeerDetailViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown Viewmodel class")
    }

}