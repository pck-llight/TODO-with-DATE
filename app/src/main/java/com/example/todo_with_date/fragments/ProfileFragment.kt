package com.example.todo_with_date.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.todo_with_date.data.User
import com.example.todo_with_date.databinding.FragmentProfileBinding
import com.example.todo_with_date.login.MainActivity

class ProfileFragment : Fragment() {
    private var _binding :FragmentProfileBinding ?= null
    private val binding:FragmentProfileBinding get() = requireNotNull(_binding)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val user = arguments?.getParcelable<User>("userdata")
        Log.d("유저 인텐트 확인", "$user")

        var name = user?.nick
        var resolution = user?.resolution

        binding.name.text = "${name}님, 환영합니다!"
        binding.resolution.text = "각오:\n$resolution"

        binding.btnLogout.setOnClickListener(){
            activity?.let {
                val intent = Intent(requireContext(), MainActivity::class.java)
                startActivity(intent)
            }
        }
    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}