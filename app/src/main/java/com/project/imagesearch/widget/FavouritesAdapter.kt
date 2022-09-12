package com.project.imagesearch.widget

import android.content.ClipData
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.imagesearch.model.Item
import com.project.imagesearch.widget.viewholder.ImageSearchViewHolder

class FavouritesAdapter : RecyclerView.Adapter<ImageSearchViewHolder>() {

    private var items : List<Item> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageSearchViewHolder {
        return ImageSearchViewHolder.create({}, parent)
    }

    override fun onBindViewHolder(holder: ImageSearchViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setItems(items: List<Item>) {
        this.items = items
        notifyDataSetChanged()
        //아이템이 바뀌었을 떄 전체를 다 다시 그린다
        //비효율적
    }


}