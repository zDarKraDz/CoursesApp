package ru.konsli.feature_auth.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.konsli.core.common.TestRepo
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: TestRepo
) : ViewModel(){
    val testText = "Hey"

}