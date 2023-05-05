package com.gvfs.mystudydocumentation.alert

sealed class AlertEvent {
    data class UserNotFound(val message: String = "Usuário não encontrado") : AlertEvent()
}
