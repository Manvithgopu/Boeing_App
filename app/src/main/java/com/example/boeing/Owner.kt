package com.example.boeing

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.boeing.databinding.ActivityMainBinding
import com.example.boeing.databinding.ActivityOwnerBinding

class Owner : AppCompatActivity() {

    lateinit var binding: ActivityOwnerBinding
    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityOwnerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences=this.getSharedPreferences("App",0)
        editor=sharedPreferences.edit()

        binding.signup.setOnClickListener(View.OnClickListener {
            editor.putString("Oft",binding.signupUsername.text.toString())
            editor.putString("Omt",binding.signupEmail.text.toString())
            editor.putString("Oot",binding.signupPassword.text.toString())
            editor.putString("Oost",binding.signupCreatePassword.text.toString())

            editor.commit()

            startActivity(Intent(this,MainActivity::class.java))
        })

    }
}