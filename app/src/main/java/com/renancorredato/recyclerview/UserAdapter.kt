package com.renancorredato.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.renancorredato.recyclerview.databinding.ResItemUserBinding

class UserAdapter(
    private val users: List<User>,
    private val onClick: (String) -> Unit,
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    inner class UserViewHolder(itemView: ResItemUserBinding) :
        RecyclerView.ViewHolder(itemView.root) {

        private val tvNameUser: TextView

        init {
            tvNameUser = itemView.tvNameUser
        }


        fun bind(userName: String, onClick: (String) -> Unit) {
            tvNameUser.text = userName
            itemView.rootView.setOnClickListener {
                onClick(userName)
            }
        }
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
        holder.bind(users[position].fullname, onClick)
    }

    override fun getItemCount(): Int {
        return users.size
    }
}