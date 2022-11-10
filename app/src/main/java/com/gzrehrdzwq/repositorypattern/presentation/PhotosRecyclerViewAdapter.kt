package com.gzrehrdzwq.repositorypattern.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.gzrehrdzwq.repositorypattern.data.entities.PhotoResponseItem
import com.gzrehrdzwq.repositorypattern.databinding.LayoutPhotosRecyclerViewItemBinding

class PhotosRecyclerViewAdapter:ListAdapter<PhotoResponseItem,PhotosRecyclerViewAdapter.ViewHolder>(ItemComparator) {


    inner class ViewHolder(private val binding:LayoutPhotosRecyclerViewItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bindView(item: PhotoResponseItem){
            binding.layoutPhotosRecyclerViewItemImageView.load(item.urls.thumb)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutPhotosRecyclerViewItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(getItem(position))
    }

}

object ItemComparator : DiffUtil.ItemCallback<PhotoResponseItem>() {
    override fun areItemsTheSame(oldItem: PhotoResponseItem, newItem: PhotoResponseItem): Boolean {
        // Id is unique.
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PhotoResponseItem, newItem: PhotoResponseItem): Boolean {
        return oldItem == newItem
    }
}