package com.renancorredato.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.renancorredato.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val users = mutableListOf<String>()
        repeat(1000){
            users.add("Renan Corredato $it" )
        }
        binding.rvUser.adapter = UserAdapter(users)
    }
}