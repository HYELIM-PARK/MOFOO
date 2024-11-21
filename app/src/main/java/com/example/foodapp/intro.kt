package com.example.foodapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class intro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        // 인트로 화면에서 액션바(상단바) 숨기기
        val mActionBar = supportActionBar
        mActionBar!!.hide()

        // 인트로 화면이 5초 후 넘어가도록 설정
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@intro, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 5000)
    }
}