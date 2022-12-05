package com.renancorredato.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.renancorredato.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val users = getData()

        binding.rvUser.adapter = UserAdapter(users) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
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
