package com.example.foodapp

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.foodapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()

        setBottomNavigationView()

        // 앱 초기 실행 시 홈화면으로 설정
        if (savedInstanceState == null) {
            binding.bottomNavigationView.selectedItemId = R.id.homeFragment
        }
    }

    private fun setBottomNavigationView() {
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeFragment -> {
                    supportFragmentManager.beginTransaction().replace(R.id.main_container, HomeFragment()).commit()
                    true
                }
                R.id.mapFragment -> {
                    supportFragmentManager.beginTransaction().replace(R.id.main_container, MapFragment()).commit()
                    true
                }
                R.id.personSearchFragment -> {
                    supportFragmentManager.beginTransaction().replace(R.id.main_container, PersonSearchFragment()).commit()
                    true
                }
                R.id.myPageFragment -> {
                    supportFragmentManager.beginTransaction().replace(R.id.main_container, MyPageFragment()).commit()
                    true
                }
                else -> false
            }
        }
    }
}