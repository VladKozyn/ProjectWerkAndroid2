package com.example.projectwerk.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.projectwerk.data.remote.GhentApiService
import com.example.projectwerk.repos.SfeerRepository


class SfeerOverviewViewModelFactory(private val repository: SfeerRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(SfeerOverviewViewModel::class.java)) {

            return SfeerOverviewViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown Viewmodel class")
    }

}