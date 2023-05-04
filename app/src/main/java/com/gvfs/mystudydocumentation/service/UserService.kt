package com.gvfs.mystudydocumentation.service

import com.gvfs.mystudydocumentation.domain.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserService @Inject constructor() {

    private val users: List<User> = listOf(User("guilherme"), User("sousa"))

    fun findName(name: String): User? {
        return users.find { user ->
            name == user.name
        }
    }
}