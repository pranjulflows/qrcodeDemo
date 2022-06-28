package com.macamp.qrcodedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.macamp.qrcodedemo.databinding.ActivityFormBinding

class FormActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFormBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onClick()
    }

    private fun onClick() {
        binding.submitBtn.setOnClickListener {
            when {
                binding.fullName.text.toString().isEmpty() -> showToast("Enter your full name")
                binding.email.text.toString().isEmpty() -> showToast("Enter your email")
                binding.mobile.text.toString().isEmpty() -> showToast("Enter your mobile")
                binding.description.text.toString().isEmpty() -> showToast("Enter your queries")
                else -> {
                    showToast("Your request submitted!")
                    startActivity(Intent(this@FormActivity, MainActivity::class.java))
                    finishAffinity()
                }
            }

        }
    }

    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}