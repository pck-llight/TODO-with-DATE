package com.example.todo_with_date.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_with_date.data.Task
import com.example.todo_with_date.databinding.ItemListBinding
import com.example.todo_with_date.viewholder.YesterdayViewHolder

class YesterdayAdapter(context: Context):RecyclerView.Adapter<YesterdayViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }

    private var unitList: List<Task> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YesterdayViewHolder {
        val binding = ItemListBinding.inflate(inflater, parent, false)

        return YesterdayViewHolder(binding)
    }

    override fun getItemCount() = unitList.size


    override fun onBindViewHolder(holder: YesterdayViewHolder, position: Int) {
        holder.onBind(unitList[position])
    }

    fun setUnitList(unitList: List<Task>){
        this.unitList = unitList.toList()
        notifyDataSetChanged()
    }
}