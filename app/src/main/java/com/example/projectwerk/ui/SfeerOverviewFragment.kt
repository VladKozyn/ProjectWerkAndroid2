package com.example.projectwerk.ui

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
import com.example.projectwerk.data.local.SfeerAndFields
import com.example.projectwerk.databinding.FragmentSfeerOverviewBinding
import com.example.projectwerk.models.Sfeer
import com.example.projectwerk.repos.RepositoryUtils
import com.example.projectwerk.utils.Status
import com.example.projectwerk.viewmodels.SfeerOverviewViewModel
import com.example.projectwerk.viewmodels.SfeerOverviewViewModelFactory


class SfeerOverviewFragment : Fragment(), SfeerClickListener {
    private val loadingDialogFragment by lazy {LoadingFragment()}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentSfeerOverviewBinding.inflate(inflater, container, false)
        val factory = SfeerOverviewViewModelFactory(RepositoryUtils.createSfeerRepository(requireContext()))
        val viewModel = ViewModelProvider(this, factory).get(SfeerOverviewViewModel::class.java)

        binding.lifecycleOwner = viewLifecycleOwner

        val adapter = SfeerAdapter(this)
        binding.adapter = adapter


        viewModel.sfeers.observe(viewLifecycleOwner, Observer {
            it?.let{
                resource ->
                when (resource.status){
                    Status.SUCCESS ->{
                        showProgress(false)
                        adapter.submitList(resource.data)
                    }
                    Status.LOADING ->{
                        showProgress(true)

                    }
                    Status.ERROR ->{
                        showProgress(false)

                    }
                }
            }
        })

        return binding.root
    }

    private fun showProgress(b: Boolean) {
        if (b) {
            if (!loadingDialogFragment.isAdded) {
                loadingDialogFragment.show(requireActivity().supportFragmentManager, "loader")
            }
            } else {
                if (!loadingDialogFragment.isAdded) {
                    loadingDialogFragment.dismissAllowingStateLoss()
                }
            }
        }


    override fun onSfeerClicked(sfeer: SfeerAndFields) {
        val directions =
            SfeerOverviewFragmentDirections.actionSfeergebiedenOverviewFragmentToSfeergebiedenDetailFragment(
                sfeer.Sfeer.recordid
            )
        findNavController().navigate(directions)
    }



}
