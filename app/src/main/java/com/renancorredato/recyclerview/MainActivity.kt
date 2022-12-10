package com.renancorredato.recyclerview

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.renancorredato.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val users = getData()

        val adapter = UserAdapter(users)

        binding.rvUser.adapter = adapter
        binding.fabSelectedUser.setOnClickListener {
            Log.i("Renan", adapter.getSelectedItem().toString())

        }
    }

    private fun getData(): MutableList<User> {
        val users = mutableListOf<User>()
        populateData(users)
        return users
    }

    private fun populateData(users: MutableList<User>) {
        repeat(1000) {
            users.add(
                User(
                    id = it.toLong(),
                    name = "Renan",
                    lastName = "Corredato"
                )
            )
        }
    }
}
