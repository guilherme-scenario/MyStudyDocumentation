package com.gvfs.mystudydocumentation.userlist

import androidx.recyclerview.widget.DiffUtil
import com.gvfs.mystudydocumentation.domain.User

class UserDiffCallback: DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }

}