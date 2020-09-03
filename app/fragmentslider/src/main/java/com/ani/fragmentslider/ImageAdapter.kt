package com.ani.fragmentslider

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter(
    private val ctx : Context,
    private val list : List<ImageData>
):RecyclerView.Adapter<ImageAdapter.ImageViewHolder>()
{
    class  ImageViewHolder(
        private val view: View
    ): RecyclerView.ViewHolder(view)
    {
        fun dp() = view.findViewById<ImageView>(R.id.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(ctx).inflate(R.layout.recycle_item, parent, false)
        return ImageViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.dp().setImageResource(list[position].dp)

    }

}