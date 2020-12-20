package com.example.uiengent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.uiengent.adapters.UiAdapter
import com.example.uiengent.adapters.UiClickListener
import com.example.uiengent.data.remote.GhentApi
import com.example.uiengent.databinding.FragmentUienOverviewBinding
import com.example.uiengent.models.Ui
import com.example.uiengent.viewmodels.UiOverviewViewModel
import com.example.uiengent.viewmodels.UiOverviewViewModelFactory

class UiOverviewFragment : Fragment(), UiClickListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentUienOverviewBinding.inflate(inflater, container, false)
        val factory = UiOverviewViewModelFactory(GhentApi.apiService)
        val viewModel = ViewModelProvider(this, factory).get(UiOverviewViewModel::class.java)

        binding.lifecycleOwner = viewLifecycleOwner

        val adapter = UiAdapter(this)
        binding.adapter = adapter


        viewModel.uien.observe(viewLifecycleOwner, Observer {
            //als wijzigingen, geef nieuwe lijst door aan adapter
            adapter.submitList(it)
        })

        return binding.root
    }

    override fun onUiClicked(ui: Ui) {
        val directions =
            UiOverviewFragmentDirections.actionUiOverviewFragmentToUiDetailFragment(
                ui
            )
        findNavController().navigate(directions)
    }
}
