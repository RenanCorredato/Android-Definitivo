package com.renancorredato.recyclerview

import android.util.Log
import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.util.forEach
import androidx.recyclerview.widget.RecyclerView
import com.renancorredato.recyclerview.databinding.ResItemUserBinding

class UserAdapter(
    private val users: List<User>
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private val usersStateArray: SparseBooleanArray = SparseBooleanArray()

    inner class UserViewHolder(itemView: ResItemUserBinding) :
        RecyclerView.ViewHolder(itemView.root) {

        private val tvNameUser: TextView
        private val cbUser: CheckBox

        init {
            tvNameUser = itemView.tvNameUser
            cbUser = itemView.cbUser
        }


        fun bind(userName: String, position: Int) {
            tvNameUser.text = userName
            cbUser.isChecked = usersStateArray[position, false]
            cbUser.setOnClickListener {
                usersStateArray.put(position, cbUser.isChecked)
                Log.i("Renan", "==============")
                usersStateArray.forEach { key, value ->

                    Log.i("Renan", "$key - $value")
                }
            }
        }
    }


    fun getSelectedItems(): List<User>{
        val selectedUser = mutableListOf<User>()
        usersStateArray.forEach { key, value ->
            if (value){
                selectedUser.add(users[key])
            }
        }
        return selectedUser
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            ResItemUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position].fullname,position)
    }

    override fun getItemCount(): Int {
        return users.size
    }
}