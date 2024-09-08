package com.example.boeing

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.boeing.databinding.ActivityRegistrationBinding

class Registration : AppCompatActivity() {

    lateinit var binding:ActivityRegistrationBinding
    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor:SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.login.setOnClickListener(View.OnClickListener {

            // Intialising Variables:
            val email = binding.loginEmail.text.toString().trim()
            val password = binding.loginPassword.text.toString().trim()

            // Checking conditions:
            if (TextUtils.isEmpty(email)) {
                binding.loginEmail.error = "Name is required"
                return@OnClickListener
            }
            if (TextUtils.isEmpty(password)) {
                binding.loginPassword.error = "Password is required"
                return@OnClickListener
            }
            if (password.length < 6) {
                binding.loginPassword.error = "Password must be >= 6 characters"
                return@OnClickListener
            }

            sharedPreferences=this.getSharedPreferences("App",0)
            editor=sharedPreferences.edit()

            editor.putString("name",email)
            editor.commit()
            startActivity(Intent(this,MainActivity::class.java))
        })


    }
}