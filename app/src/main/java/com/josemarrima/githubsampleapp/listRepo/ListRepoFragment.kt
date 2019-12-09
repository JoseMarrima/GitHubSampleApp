package com.josemarrima.githubsampleapp.listRepo

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController

import com.josemarrima.githubsampleapp.R
import com.josemarrima.githubsampleapp.databinding.ListRepoFragmentBinding

class ListRepoFragment : Fragment() {

    private lateinit var viewModel: ListRepoViewModel

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

        viewModel = ViewModelProviders.of(this).get(ListRepoViewModel::class.java)

        return binding.root
    }
}
