package com.gvfs.mystudydocumentation.hello

sealed class HelloEvent {
    data class UserNotFound(val message: String) : HelloEvent()
}
