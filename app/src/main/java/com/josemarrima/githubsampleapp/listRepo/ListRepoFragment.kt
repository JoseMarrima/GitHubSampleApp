package com.josemarrima.githubsampleapp.listRepo

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController

import com.josemarrima.githubsampleapp.R
import com.josemarrima.githubsampleapp.databinding.ListRepoFragmentBinding
import com.josemarrima.githubsampleapp.di.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class ListRepoFragment : DaggerFragment() {

    private lateinit var viewModel: ListRepoViewModel

    @Inject
    lateinit var factory: ViewModelProviderFactory

    private val adapter = ListRepoAdapter(ClickListener {
        this.findNavController().navigate(ListRepoFragmentDirections
            .actionListRepoFragmentToRepoDetailsFragment(it))
    })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: ListRepoFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.list_repo_fragment, container, false)

        binding.lifecycleOwner = this

        binding.listItemRv.adapter = adapter

        viewModel = ViewModelProviders.of(this, factory).get(ListRepoViewModel::class.java)

        viewModel.repos.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })

        return binding.root
    }
}
