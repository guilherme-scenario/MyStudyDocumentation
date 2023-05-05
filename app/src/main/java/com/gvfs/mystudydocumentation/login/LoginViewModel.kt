package com.gvfs.mystudydocumentation.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gvfs.mystudydocumentation.alert.AlertEvent
import com.gvfs.mystudydocumentation.domain.User
import com.gvfs.mystudydocumentation.service.UserService
import dagger.hilt.android.lifecycle.HiltViewModel
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val userService: UserService) : ViewModel() {

    val user: MutableLiveData<User?> = MutableLiveData()
    val events: MutableLiveData<AlertEvent> = MutableLiveData()

    fun findName(name:String) {
        val events: MutableLiveData<AlertEvent> = MutableLiveData()
        val existUser = userService.findName(name)
        if (existUser == null)
            events.value = AlertEvent.UserNotFound()
        else user.value = existUser
    }

    fun findUser(email:String, password: String) {
        val existsUser = userService.findUser(email, password)
        if (existsUser != null){
            user.value = existsUser
        } else {
            events.value = AlertEvent.UserNotFound()

        }


    }

    fun isAuthenticated(user: MutableLiveData<User>): Boolean {
        return userService.isAuthenticated(user)
    }
}