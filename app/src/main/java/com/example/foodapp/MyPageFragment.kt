package com.example.foodapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.foodapp.databinding.FragmentHomeBinding
import com.example.foodapp.databinding.FragmentMyPageBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


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