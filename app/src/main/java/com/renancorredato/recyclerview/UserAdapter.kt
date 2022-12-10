package com.renancorredato.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.renancorredato.recyclerview.databinding.ResItemUserBinding

class UserAdapter(
    private val users: List<User>
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private var selectedPosition: Int = -1

    inner class UserViewHolder(itemView: ResItemUserBinding) :
        RecyclerView.ViewHolder(itemView.root) {

        private val tvNameUser: TextView
        private val rbUser: RadioButton

        init {
            tvNameUser = itemView.tvNameUser
            rbUser = itemView.rbUser
        }


        fun bind(userName: String, position: Int) {
            tvNameUser.text = userName
            rbUser.isChecked = (position == selectedPosition)
            rbUser.setOnClickListener {
                val oldSelectdPosition = selectedPosition
                selectedPosition = position
                notifyItemChanged(oldSelectdPosition)
            }
        }
    }


    fun getSelectedItem(): User {
        return users[selectedPosition]

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
        holder.bind(users[position].fullname, position)
    }

    override fun getItemCount(): Int {
        return users.size
    }
}