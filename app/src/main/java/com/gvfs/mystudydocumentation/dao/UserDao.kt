package com.gvfs.mystudydocumentation.dao

import com.gvfs.mystudydocumentation.domain.User

class UserDao {
    fun insert(user: User) {
        users.add(user)
    }

    fun findAll(): List<User> {
        return users.toList()
    }

    companion object {
        private val users = mutableListOf<User>(
            User(
                "guilherme",
            ),
            User(
                "josé",
            ),
            User(
                "maria",
            ),
            User(
                "joão",
            ),
            User(
                "ana",
            ),
        )
    }
}