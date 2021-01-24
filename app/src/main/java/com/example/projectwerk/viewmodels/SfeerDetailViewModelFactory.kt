package com.example.projectwerk.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.projectwerk.data.remote.GhentApiService
import com.example.projectwerk.repos.SfeerRepository


class SfeerDetailViewModelFactory(private val repository: SfeerRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(SfeerDetailViewModelFactory::class.java)) {

            return SfeerDetailViewModelFactory(repository) as T
        }

        throw IllegalArgumentException("Unknown Viewmodel class")
    }

}