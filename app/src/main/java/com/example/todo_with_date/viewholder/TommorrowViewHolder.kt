package com.example.todo_with_date.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.todo_with_date.data.Task
import com.example.todo_with_date.databinding.ItemListBinding

class TommorrowViewHolder(private var binding : ItemListBinding): RecyclerView.ViewHolder(binding.root) {
    fun onBind(listdata : Task) {
        binding.listUnit.text = listdata.content
    }
}