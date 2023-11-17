package com.example.todo_with_date.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.todo_with_date.R
import com.example.todo_with_date.data.User
import com.example.todo_with_date.databinding.ActivitySignUpBinding

class SignUp : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = binding.edId
        val pw = binding.edPw
        var resolution = binding.edResolution
        var nickname = binding.edNick

        binding.btnSignUp.setOnClickListener {
            if (id.text.toString() != "" && pw.text.toString() != "" && resolution.text.toString() != "" && nickname.text.toString() != "") {
                if (id.text.toString().length >= 6) {
                    if (pw.text.toString().length in 8..12) {
                        if (nickname.text.toString().isNotEmpty()) {
                            Toast.makeText(this, "회원가입 되었습니다.", Toast.LENGTH_SHORT).show()
                            var user = User(
                                binding.edId.text.toString(),
                                binding.edPw.text.toString(),
                                binding.edNick.text.toString(),
                                binding.edResolution.text.toString()
                            )
                            Log.d("입력 값 확인","${id},${pw},${nickname},${resolution}")
                            val intent = Intent(this, MainActivity::class.java)
                            intent.putExtra("userdata", user)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, "닉네임을 1글자 이상 \n입력해주세요", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(this, "비밀번호를 8~12로 만들어주세요", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "아이디를 6글자 이상으로 해주세요", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}