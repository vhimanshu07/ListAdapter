package com.example.listadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter : ListAdapter<Item, ItemAdapter.OwnViewHolder>(DiffUtilComparator()) {


    class OwnViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.title)
        val aboutIt = view.findViewById<TextView>(R.id.subTitle)
        fun bind(item: Item) {
            name.text = item.name
            aboutIt.text = item.initial
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OwnViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return OwnViewHolder(view)
    }

    override fun onBindViewHolder(holder: OwnViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    class DiffUtilComparator : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {

            // As we are using data class we can directly this statement as it implements .equals function internally
            // Else we need to check each individual values in Item class
            return oldItem == newItem
        }

    }

}