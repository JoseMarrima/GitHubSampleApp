package com.josemarrima.githubsampleapp.listRepo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.josemarrima.githubsampleapp.databinding.ItemRepoBinding
import com.josemarrima.githubsampleapp.domain.Repo

class ListRepoAdapter (private val clickListener: ClickListener) :
    ListAdapter<Repo, RecyclerView.ViewHolder>(RepoDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return RepoViewHolder(ItemRepoBinding
            .inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as RepoViewHolder).bind(clickListener, getItem(position))
    }


    class RepoViewHolder(private val binding: ItemRepoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: ClickListener,item: Repo) {
            binding.apply {
                clickListener = listener
                repo = item
                executePendingBindings()
            }
        }
    }
}

private class RepoDiffCallback : DiffUtil.ItemCallback<Repo>() {
    override fun areItemsTheSame(oldItem: Repo, newItem: Repo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Repo, newItem: Repo): Boolean {
        return oldItem == newItem
    }

}

class ClickListener(val clickListener: (repo: Repo) -> Unit) {
    fun onClick(repo: Repo) = clickListener(repo)
}