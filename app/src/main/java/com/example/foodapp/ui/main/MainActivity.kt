package com.example.foodapp.ui.main

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.foodapp.R
import com.example.foodapp.databinding.ActivityMainBinding
import com.example.foodapp.ui.fragments.HomeFragment
import com.example.foodapp.ui.fragments.MapFragment
import com.example.foodapp.ui.fragments.MyPageFragment
import com.example.foodapp.ui.fragments.PersonSearchFragment
import com.example.foodapp.viewmodel.SharedViewModel

class MainActivity : AppCompatActivity() {
    private val sharedViewModel : SharedViewModel by viewModels()

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //==================== light 버전 설정 & 액션바 숨기기 =====================
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()
        //======================================================================

        // ViewModel에 데이터 저장
        val id = intent.getStringExtra("id")?: ""
        val pw = intent.getStringExtra("pw")?: ""
        sharedViewModel.setUserCredentials(id, pw)

        // 하단 네비게이션 설정
        setBottomNavigationView()

        // 앱 초기 실행 시 홈화면으로 설정
        if (savedInstanceState == null) {
            binding.bottomNavigationView.selectedItemId = R.id.homeFragment
        }
    }


    private fun setBottomNavigationView() {
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            val fragment = when (item.itemId) {
                R.id.homeFragment -> HomeFragment()
                R.id.mapFragment -> MapFragment()
                R.id.personSearchFragment -> PersonSearchFragment()
                R.id.myPageFragment -> MyPageFragment()
                else -> null
            }
            fragment?.let {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.main_container, it)
                    .commit()
            }
            fragment != null
        }
    }

}