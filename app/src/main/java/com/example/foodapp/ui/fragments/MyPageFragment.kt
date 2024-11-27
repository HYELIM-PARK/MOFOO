package com.example.foodapp.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.foodapp.ui.main.LoginActivity
import com.example.foodapp.databinding.FragmentMyPageBinding

class MyPageFragment : Fragment() {

    private lateinit var binding: FragmentMyPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyPageBinding.inflate(inflater, container, false)

        val view = binding.root
        binding.loginBtn.setOnClickListener {
            setFrag("Login")
        }

        return view
    }

    private fun setFrag(frag : String) {
        when(frag) {
            "Login" -> {
                startActivity(Intent(requireActivity(), LoginActivity::class.java))
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MyPageFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}