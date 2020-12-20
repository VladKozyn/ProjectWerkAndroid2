package com.example.projectwerk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.projectwerk.adapters.SfeerAdapter
import com.example.projectwerk.adapters.SfeerClickListener
import com.example.projectwerk.data.remote.GhentApi
import com.example.projectwerk.models.Sfeer
import com.example.projectwerk.viewmodels.SfeerOverviewViewModel
import com.example.projectwerk.viewmodels.SfeerOverviewViewModelFactory


class SfeerOverviewFragment : Fragment(), SfeerClickListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentSfeerenOverviewBinding.inflate(inflater, container, false)
        val factory = SfeerOverviewViewModelFactory(GhentApi.apiService)
        val viewModel = ViewModelProvider(this, factory).get(SfeerOverviewViewModel::class.java)

        binding.lifecycleOwner = viewLifecycleOwner

        val adapter = SfeerAdapter(this)
        binding.adapter = adapter


        viewModel.sfeer.observe(viewLifecycleOwner, Observer {
            //als wijzigingen, geef nieuwe lijst door aan adapter
            adapter.submitList(it)
        })

        return binding.root
    }

    override fun onSfeerClicked(sfeer: Sfeer) {
        val directions =
            SfeerOverviewFragmentDirections.actionSfeerOverviewFragmentToSfeerDetailFragment(
                sfeer
            )
        findNavController().navigate(directions)
    }


}
