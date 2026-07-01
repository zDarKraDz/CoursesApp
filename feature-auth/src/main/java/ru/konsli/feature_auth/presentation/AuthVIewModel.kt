package ru.konsli.feature_auth.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import ru.konsli.core.common.TestRepo
import ru.konsli.feature_auth.domain.validator.EmailValidator
import ru.konsli.feature_auth.domain.validator.PasswordValidator
import javax.inject.Inject

@HiltViewModel
class AuthVIewModel @Inject constructor(
) : ViewModel(){

    private val _state = MutableStateFlow(AuthState())
    val state = _state.asStateFlow()

    fun onEmailChange(email: String){
        _state.update {
            it.copy(email = email)
        }
    }

    fun onPasswordChange(password: String){
        _state.update {
            it.copy(password = password)
        }
    }

    fun validateData(){
        val currentState = _state.value

        val isEmailValid = EmailValidator.validate(currentState.email)
        val isPasswordValid = PasswordValidator.validate(currentState.password)

        _state.update {
            it.copy(
                isAuthorized = isEmailValid && isPasswordValid,
                isEmailError = !isEmailValid && currentState.email.isNotEmpty(),
                isPasswordError = !isPasswordValid && currentState.password.isNotEmpty()
            )
        }

    }

}