package com.example.boeing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.boeing.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this,Owner::class.java))
        })
        binding.textView4.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this,Docker::class.java))
        })
        binding.textView6.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this,Notifiction::class.java))
        })
    }
}