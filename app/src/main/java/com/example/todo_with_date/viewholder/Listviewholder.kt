package com.example.todo_with_date.viewholder

import android.view.View
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_with_date.data.Task
import com.example.todo_with_date.databinding.ItemListBinding
import com.example.todo_with_date.fragments.ListFragment

class Listviewholder(private val binding : ItemListBinding) :RecyclerView.ViewHolder(binding.root){
    private val checkBox: CheckBox = binding.checkbox


    fun onBind(listdata : Task, isTrue: Boolean, aa: Boolean) {
        with(binding) {
            listUnit.setText(listdata.content.toString())

            if(!aa || isTrue) {
                listUnit.visibility = View.VISIBLE
                checkbox.visibility = View.VISIBLE
                checkbox.isChecked = isTrue
            }
            else {
                listUnit.visibility = View.GONE
                checkbox.visibility = View.GONE
            }
        }
    }
}