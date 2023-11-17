package com.example.todo_with_date.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_with_date.data.Task
import com.example.todo_with_date.databinding.ItemListBinding
import com.example.todo_with_date.viewholder.Listviewholder

class ListAdapter(context: Context) : RecyclerView.Adapter<Listviewholder>() {
    private val inflater by lazy { LayoutInflater.from(context) }

    private var unitList: List<Task> = emptyList()

    private var aa: Boolean = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Listviewholder {
        return Listviewholder(ItemListBinding.inflate(inflater, parent, false))

    }

    override fun getItemCount() = unitList.size


    override fun onBindViewHolder(holder: Listviewholder, position: Int) {
        holder.onBind(unitList[position], unitList[position].checkBox, aa)
    }

    fun setUnitList(list: List<Task>){
        this.unitList = list
        notifyDataSetChanged()
    }

    fun setToggle(isCheck: Boolean) {
        aa = isCheck
    }
}