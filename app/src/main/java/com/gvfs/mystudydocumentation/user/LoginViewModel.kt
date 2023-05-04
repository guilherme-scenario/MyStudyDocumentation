package com.gvfs.mystudydocumentation.user

import androidx.lifecycle.ViewModel
import com.gvfs.mystudydocumentation.service.UserService
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val userService: UserService
) : ViewModel() {

    fun login(email: String, password:String): Any? {
        return userService.login(email, password)
    }
}