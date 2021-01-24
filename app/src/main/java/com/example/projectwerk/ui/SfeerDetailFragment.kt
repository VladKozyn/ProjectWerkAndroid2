package com.example.projectwerk.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.projectwerk.databinding.FragmentSfeerDetailBinding
import com.example.projectwerk.repos.RepositoryUtils
import com.example.projectwerk.viewmodels.SfeerDetailViewModel
import com.example.projectwerk.viewmodels.SfeerDetailViewModelFactory

class SfeerDetailFragment : Fragment() {
    private val arguments: SfeerDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentSfeerDetailBinding.inflate(inflater,container,false)
        val factory = SfeerDetailViewModelFactory(RepositoryUtils.createSfeerRepository((requireContext())))
        val viewModel = ViewModelProvider(this,factory).get(SfeerDetailViewModel::class.java)

        viewModel.updateSfeer(arguments.sfeerid)
        viewModel.sfeer.observe(viewLifecycleOwner, {
            binding.sfeer =it
        })



        return  binding.root
    }
}