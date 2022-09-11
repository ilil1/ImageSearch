package com.project.imagesearch.widget

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.project.imagesearch.model.Item
import com.project.imagesearch.widget.viewholder.ImageSearchViewHolder

class ImageSearchAdapter(
    private val like: (Item) -> Unit
) : PagingDataAdapter<Item, ImageSearchViewHolder>(comparator) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImageSearchViewHolder {
        return ImageSearchViewHolder.create(like, parent)
    }

    override fun onBindViewHolder(holder: ImageSearchViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    companion object {
        val comparator = object : DiffUtil.ItemCallback<Item>() {

            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem.thumbnail == newItem.thumbnail
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem == newItem
            }
        }
    }
}