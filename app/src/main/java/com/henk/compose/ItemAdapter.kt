package com.henk.compose

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.henk.compose.databinding.ItemBinding

class ItemAdapter(var itemClick: ItemClick, private val list: MutableList<Bean>):RecyclerView.Adapter<ItemHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {

        val binding:ItemBinding = ItemBinding.inflate(LayoutInflater.from(parent.context))
        return ItemHolder(binding,itemClick)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
       return list.size
    }
}

class ItemHolder(private val binding: ItemBinding,private val itemClick: ItemClick):RecyclerView.ViewHolder(binding.root){
    fun bind(bean: Bean){
        binding.item.text=bean.title
        binding.item.setTextColor(Color.WHITE)
        binding.item.setBackgroundColor(Color.CYAN)
        binding.item.setOnClickListener {
            itemClick.click(bean)
        }
    }
}

interface ItemClick{
    fun click(bean: Bean)
}

