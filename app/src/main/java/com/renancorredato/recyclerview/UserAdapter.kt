package com.renancorredato.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.renancorredato.recyclerview.databinding.ResItemUserBinding

class UserAdapter(
    private val users: MutableList<User>
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

    fun removedDataSetChanged(user: User) {
        users.add(0,user)
        notifyDataSetChanged() // notificado todos itens mudaram com um lista muito grande a performacia vai ser muito ruim, basicamente recriar a lista novamente
    }

    fun removedUserRange(user: User) {

        users.removeAt(0)
        users.removeAt(1)
        users.removeAt(2)
        notifyItemRangeChanged(0, 3) // notificado remove um lote item da lista
    }

    fun removedUser(user: User) {
        val position = 0
        if (position >= users.size || position < 0) {
            //Posição não existe
            return
        }
        users.removeAt(position)
        notifyItemRemoved(position) // notificado remove um item da lista
    }

    fun addNewUser(user: User) {
        users.removeAt(0)
        notifyItemRemoved(0)


//        users.removeAt(0)
//        users.add(0, user)
//        users.removeAt(1)
//        users.add(1, user)
//        users.removeAt(2)
//        users.add(2, user)
//        notifyItemRangeChanged(0, 3) // noticação que o lote de item foi mudado

//        users.removeAt(0)
//        users.add(0,user)
//        notifyItemChanged(0) // noticação que o item foi mudado


//        users.add(0,user)
//        users.add(0,user)
//        users.add(0,user)
//        notifyItemRangeChanged(0,4 ) // noticado que apartir da posição 0 vai atualizar, maia 4 posição


        //users.add(0,user)
        //users.add(user)
        //notifyItemInserted(3) // adiciona na posição do index que voce escolher
        // notifyItemInserted(0) // adiciona na primeira posição
        // notifyItemInserted(users.size -1) // adiciona no fim da lista
        //Log.i("Renan","Tamanho do dataset:${users.size}") verificar o tamanho
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