package com.gvfs.mystudydocumentation.service

import androidx.lifecycle.MutableLiveData
import com.gvfs.mystudydocumentation.dao.UserDao
import com.gvfs.mystudydocumentation.domain.User
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserService @Inject constructor() {

    private val dao = UserDao();

    private var users: List<User> = dao.findAll()

    fun findName(name: String): User? {
        return users.find { user ->
            name == user.name
        }
    }

    fun findByEmail(email: String): User? {
        return users.find { user ->
            email == user.email
        }
    }

    fun findUser(email: String, password: String): User? {
        return users.find { user ->
            email == user.email && password == user.password
        }
    }

    fun isAuthenticated(user: MutableLiveData<User>): Boolean {
        users.find { user_ ->
            user_ == user.value
        }
        return true
    }
}