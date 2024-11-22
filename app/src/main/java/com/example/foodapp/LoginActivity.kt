package com.example.foodapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.foodapp.databinding.ActivityLoginBinding
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()

        val loginBtn: Button = findViewById(R.id.loginBtn)
        binding.apply {
            loginBtn.setOnClickListener() {
                val tvid: TextInputEditText = findViewById(R.id.idField)
                val tvpw: TextInputEditText = findViewById(R.id.pwField)
                val id = tvid.text.toString()
                val pw = tvpw.text.toString()
                val fragment = HomeFragment.newInstance(id,pw)
                setFragment(fragment)
            }
        }
//        setFragment(HomeFragment())
    }

    private fun setFragment(fragment : Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.homeFragment, fragment)
            .commit()
    }
}