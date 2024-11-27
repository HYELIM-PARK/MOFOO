package com.example.foodapp.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.foodapp.R
import com.example.foodapp.databinding.ActivityLoginBinding
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.v("test","test : login page load!!")

        //==================== light 버전 설정 & 액션바 숨기기 =====================
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()
        //======================================================================

        binding.apply {
            loginBtn.setOnClickListener() {
                Log.v("test","test : click login button!!")
                val inputId: TextInputEditText = findViewById(R.id.idField)
                val inputPw: TextInputEditText = findViewById(R.id.pwField)
                val id = inputId.text.toString()
                val pw = inputPw.text.toString()

                val intent = Intent(this@LoginActivity, MainActivity::class.java).apply {
                    putExtra("id", id)
                    putExtra("pw", pw)
                }
                startActivity(intent)
                finish() //로그인 액티비티 종료

//                val fragment = HomeFragment.newInstance(id,pw)
//                Log.v("test", "test : setFragment() start!")
//                setFragment(fragment)
//                Log.v("test", "test : setFragment() end!")
            }
        }
    }

//    private fun setFragment(fragment : Fragment) {
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.main_container, fragment)
//            .commit()
//    }
}