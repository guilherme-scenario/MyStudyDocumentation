package com.gvfs.mystudydocumentation.hello

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gvfs.mystudydocumentation.alert.AlertEvent
import com.gvfs.mystudydocumentation.domain.User
import com.gvfs.mystudydocumentation.service.UserService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HelloViewModel @Inject constructor(private val userService: UserService): ViewModel() {

    val user: MutableLiveData<User?> = MutableLiveData()
    val events: MutableLiveData<AlertEvent> = MutableLiveData()

    fun findByEmail(email:String) {
        val existUser = userService.findByEmail(email)
        if (existUser == null)
            events.value = AlertEvent.UserNotFound()
        else user.value = existUser
    }
}