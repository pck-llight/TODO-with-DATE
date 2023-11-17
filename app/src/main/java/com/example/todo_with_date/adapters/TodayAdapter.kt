package com.example.todo_with_date.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_with_date.data.Task
import com.example.todo_with_date.databinding.ItemListBinding
import com.example.todo_with_date.viewholder.TodayViewholder

class TodayAdapter(context: Context) : RecyclerView.Adapter<TodayViewholder>(){
    private val inflater by lazy { LayoutInflater.from(context) }

    private var unitList: List<Task> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodayViewholder {
        val binding = ItemListBinding.inflate(inflater, parent, false)
        return TodayViewholder(binding)
    }

    override fun getItemCount() = unitList.size

    override fun onBindViewHolder(holder: TodayViewholder, position: Int) {
        this.unitList = unitList.toList()
        notifyDataSetChanged()
    }
    fun setUnitList(unitList: List<Task>){
        this.unitList = unitList.toList()
        notifyDataSetChanged()
    }
}