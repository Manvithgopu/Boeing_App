package com.example.boeing

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.boeing.databinding.ActivityDockerBinding
import com.example.boeing.databinding.ActivityRegistrationBinding

class Docker : AppCompatActivity() {

    lateinit var binding: ActivityDockerBinding
    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDockerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences=this.getSharedPreferences("App",0)
        editor=sharedPreferences.edit()

        binding.signup.setOnClickListener(View.OnClickListener {
            editor.putString("Det",binding.signupUsername.text.toString())
            editor.putString("Dmt",binding.signupEmail.text.toString())
            editor.putString("Dft",binding.signupPassword.text.toString())
            editor.putString("Dct",binding.signupCreatePassword.text.toString())

            editor.commit()
            startActivity(Intent(this,MainActivity::class.java))
        })
    }
}