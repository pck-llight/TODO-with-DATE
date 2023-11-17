package com.example.todo_with_date

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.todo_with_date.data.User
import com.example.todo_with_date.databinding.ActivityMainPageBinding
import com.example.todo_with_date.fragments.ListFragment
import com.example.todo_with_date.fragments.MainFragment
import com.example.todo_with_date.fragments.ProfileFragment

class MainPage : AppCompatActivity() {

    private lateinit var binding: ActivityMainPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainPageBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
    private fun clickBottomnav(){
        var user : User = intent.getParcelableExtra("userdata")?: User("","","","")
        Log.d("인텐트 체크", "$user")

        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_date -> {
                    replaceFragment(MainFragment())
                    true
                }

                R.id.nav_list -> {
                    replaceFragment(ListFragment())
                    true
                }

                R.id.nav_profile -> {
                    var bundle = Bundle()
                    bundle.putParcelable("userdata",user)
                    bundle = Bundle().apply {
                        putParcelable("userdata", user)
                    }
                    val fragment = ProfileFragment().apply {
                        arguments = bundle
                    }

                    replaceFragment(fragment)
                    true
                }
                else -> false
            }
        }
    }

    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_place, fragment)
            .commit()
    }

    override fun onStart() {
        super.onStart()
        clickBottomnav()
    }
}
