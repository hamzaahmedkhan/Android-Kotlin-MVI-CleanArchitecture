package com.mi.mvi.presentation.auth.state

sealed class AuthEventState {

    data class LoginEvent(
        val email: String,
        val password: String
    ) : AuthEventState()

    data class RegisterEvent(
        val email: String,
        val username: String,
        val password: String,
        val confirmPassword: String
    ) : AuthEventState()

    object CheckTokenEvent : AuthEventState()

    object None : AuthEventState()
}
