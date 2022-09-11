package com.project.imagesearch.widget.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.project.imagesearch.R
import com.project.imagesearch.databinding.ImageSearchItemBinding
import com.project.imagesearch.model.Item

class ImageSearchViewHolder(
    private val like: (Item) -> Unit,
    private val binding: ImageSearchItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Item?) {
        item?.let { item ->
            Glide.with(binding.root)
                .load(item.thumbnail)
                .centerCrop()
                .into(binding.imageView)

            binding.imageView.setOnClickListener {
                like.invoke(item)//image click 시 호출이 되고 외부에 등록된 like 호출
            }
        }
    }

    companion object {
        fun create(
            like: (Item) -> Unit,
            parent: ViewGroup
        ): ImageSearchViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.image_search_item, parent, false)
            val binding = ImageSearchItemBinding.bind(view)
            return ImageSearchViewHolder(like, binding)
        }
    }
}