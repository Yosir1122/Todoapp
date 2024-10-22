package com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.apply {
            btnList.setOnClickListener{
                startActivity(Intent(this@MainActivity, ListActivity::class.java))
            }
            addList.setOnClickListener {
                startActivity(Intent(this@MainActivity,AddActivity::class.java))
            }
        }
    }

}