package com.example.projectwerk.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.projectwerk.data.remote.GhentApiService


class SfeerOverviewViewModelFactory(private val apiService: GhentApiService) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(SfeerOverviewViewModel::class.java)) {

            return SfeerOverviewViewModel(apiService) as T
        }

        throw IllegalArgumentException("Unknown Viewmodel class")
    }

}