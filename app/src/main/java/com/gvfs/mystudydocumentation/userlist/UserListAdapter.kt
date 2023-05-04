package com.gvfs.mystudydocumentation.userlist

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gvfs.mystudydocumentation.databinding.FragmentUserListBinding
import com.gvfs.mystudydocumentation.databinding.UserItemBinding
import com.gvfs.mystudydocumentation.databinding.UsersListBinding
import com.gvfs.mystudydocumentation.domain.User

class UserListAdapter(
    users: List<User>
): RecyclerView.Adapter<UserListAdapter.ViewHolder>() {

    private val users =users.toMutableList()

    inner class ViewHolder(private val binder: UserItemBinding) : RecyclerView.ViewHolder(binder.root) {

        fun bindUsers(user: User) {
            val name = binder.userItemNome
            name.text = user.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = UserItemBinding.inflate(inflater, parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: UserListAdapter.ViewHolder, position: Int) {
         val user = users[position]
         holder.bindUsers(user)
    }

    fun updateUsers(newUsers: List<User>) {
        users.clear()
        users.addAll(newUsers)
        notifyDataSetChanged()
    }
}