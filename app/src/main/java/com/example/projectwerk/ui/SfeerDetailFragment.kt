package com.example.projectwerk.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.projectwerk.SfeerDetailFragmentArgs
import com.example.projectwerk.databinding.FragmentSfeerDetailBinding
import com.example.projectwerk.viewmodels.SfeerDetailViewModel

class SfeerDetailFragment : Fragment() {
    val arguments: SfeerDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentSfeerDetailBinding.inflate(inflater,container,false)
        val viewModel = ViewModelProvider(this).get((SfeerDetailViewModel::class.java))


        viewModel.sfeer.observe(viewLifecycleOwner, Observer {
            binding.sfeer =it
        })

        viewModel.updateSfeer(arguments.sfeerid)

        return  binding.root
    }
}