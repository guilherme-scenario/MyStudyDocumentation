package com.gvfs.mystudydocumentation.hello

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.material.snackbar.Snackbar
import com.gvfs.mystudydocumentation.domain.User
import com.gvfs.mystudydocumentation.service.UserService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HelloViewModel @Inject constructor(private val userService: UserService): ViewModel() {

    val user: MutableLiveData<User?> = MutableLiveData()
    val events: MutableLiveData<HelloEvent> = MutableLiveData()

    fun findName(name:String) {
        val existUser = userService.findName(name)
        if (existUser == null)
            events.value = HelloEvent.UserNotFound("Usuário não encontrado")
        else user.value = existUser
    }
}