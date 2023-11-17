package com.example.todo_with_date.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.todo_with_date.adapters.ListAdapter
import com.example.todo_with_date.data.Task
import com.example.todo_with_date.databinding.FragmentListBinding
import java.util.Date

class ListFragment :Fragment(){
    private var _binding : FragmentListBinding ?= null
    private val binding : FragmentListBinding get() = requireNotNull(_binding)

    private val dumlist : List<Task> = listOf(
        Task("완료 된 할일", false),
        Task("완료 된 할일", false),
        Task("완료 된 할일", false),
        Task("완료 된 할일", true),
        Task("완료 된 할일", true),
        Task("완료 된 할일", true),
        Task("완료 된 할일", true),
        Task("완료 된 할일", true),
        Task("완료 된 할일", true),
        Task("완료 된 할일", true),
        Task("완료 된 할일", true),
        Task("완료 된 할일", false),
        Task("완료 된 할일", false),
        Task("완료 된 할일", false),
        Task("완료 된 할일", false),
        Task("완료 된 할일", false),
        Task("완료 된 할일", false),
        Task("완료 된 할일", false),
        Task("완료 된 할일", false),
        Task("완료 된 할일", false),
        Task("완료 된 할일", false),
        Task("완료 된 할일", false),
        Task("완료 된 할일", false),
        Task("완료 된 할일", false),

    )
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listAdapter  = ListAdapter(requireContext())
        listAdapter.setUnitList(dumlist)
        binding.rcvList.adapter = listAdapter

        binding.switchList.setOnCheckedChangeListener { compoundButton, checked ->
            if(checked) {
                listAdapter.setToggle(true)
                listAdapter.notifyDataSetChanged()
            }
            else {
                listAdapter.setToggle(false)
                listAdapter.notifyDataSetChanged()
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}