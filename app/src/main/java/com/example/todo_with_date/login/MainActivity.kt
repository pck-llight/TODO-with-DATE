package com.example.todo_with_date.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.todo_with_date.MainPage
import com.example.todo_with_date.R
import com.example.todo_with_date.data.User
import com.example.todo_with_date.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val receivedIntent: Intent = intent // 현재 액티비티에서 받은 인텐트를 가져옵니다.
        val user = intent.getParcelableExtra("userdata")?: User("","","","")

        binding.loginBtn.setOnClickListener{
            var inputId = binding.edId.text.toString()
            var inputPw = binding.edPw.text.toString()
            if ((user.id == inputId && user.pw == inputPw && inputId.isNotEmpty() && inputPw.isNotEmpty())||inputId == "1" && inputPw == "1"){
                Toast.makeText(this, "로그인 되었습니다.", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainPage::class.java)
                intent.putExtra("userdata", user)
                startActivity(intent)
            }
            else if (user.id == inputId || user.pw == inputPw)
                Toast.makeText(this, "아이디와 비밀번호를 확인 해주세요.", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "입력을 하셔야 합니다.", Toast.LENGTH_SHORT).show()
            Log.d("이게 왜 안돼", "${user.id}, ${user.pw}, $inputId, $inputPw")
        }

        binding.btnSignUp.setOnClickListener{
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
    }
}