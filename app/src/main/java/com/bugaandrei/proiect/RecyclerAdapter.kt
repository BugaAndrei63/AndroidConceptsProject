package com.bugaandrei.proiect

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class RecyclerAdapter(locationList: MutableList<String>): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var images = intArrayOf(R.drawable.people,R.drawable.people,R.drawable.people,R.drawable.people,R.drawable.people,R.drawable.people,R.drawable.people,R.drawable.people,R.drawable.people)

    private var locations: MutableList<String> = locationList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val i = LayoutInflater.from(parent.context).inflate(R.layout.recycler_layout, parent, false)
        return ViewHolder(i)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.itemTitle.text = locations[position]

        holder.itemImage.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return locations.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        lateinit var itemImage: ImageView
        lateinit var itemTitle: TextView


        init
        {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)


            itemView.setOnClickListener()
            {
                val position : Int = getAbsoluteAdapterPosition()
            }
        }
    }



}