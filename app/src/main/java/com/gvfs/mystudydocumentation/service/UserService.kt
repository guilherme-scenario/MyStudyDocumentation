package com.gvfs.mystudydocumentation.service

import com.gvfs.mystudydocumentation.user.User
import javax.inject.Inject

class UserService @Inject constructor() {

    var userLogged = User(
        name = "João Silva",
        password = "1234",
        email = "joao@mail.com",
        image = "https://images.pexels.com/photos/2379004/pexels-photo-2379004.jpeg"
    )

    fun login(email: String, password: String): Any? {
        return if (email == userLogged.email && password == userLogged.password)
            userLogged
        else null
    }
}