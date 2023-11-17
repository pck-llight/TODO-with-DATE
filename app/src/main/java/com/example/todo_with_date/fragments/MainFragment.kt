package com.example.todo_with_date.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.todo_with_date.adapters.TodayAdapter
import com.example.todo_with_date.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var _binding : FragmentMainBinding ?= null
    private val binding : FragmentMainBinding get() = requireNotNull(_binding)

    private val datalist = listOf<Int>(1,2,3,4,5,)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val mainAdapter = TodayAdapter(requireContext())
//        binding..adapter =
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}