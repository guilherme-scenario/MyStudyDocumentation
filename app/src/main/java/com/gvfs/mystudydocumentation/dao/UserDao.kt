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
                "Guilherme",
                "guilherme@mail.com",
                "123456"
            ),
            User(
                "José",
                "jose@mail.com",
                "123456"
            ),
            User(
                "Maria",
                "maria@mail.com",
                "123456"
            ),
            User(
                "João",
                "joao@mail.com",
                "123456"
            ),
            User(
                "Ana",
                "ana@mail.com",
                "123456"
            ),
        )
    }
}