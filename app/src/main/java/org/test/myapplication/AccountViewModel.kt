package org.test.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.healthsignz.doctor.account.model.LoginRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AccountViewModel @Inject constructor(private val repository: IAccountRepository) : BaseViewModel() {

    private val _loginSuccess = SingleLiveEvent<Boolean>()
    val isLoginSuccess: LiveData<Boolean>
        get() {
            return _loginSuccess
        }

    private val _loginError = SingleLiveEvent<Boolean>()
    val isLoginError: LiveData<Boolean>
        get() {
            return _loginError
        }

    fun doAuthenticate(userName: String?, password: String?) {
        _showLoading.value = true
        viewModelScope.launch {
            runCatching {
                withContext(IO) {
                    repository.doLogin(LoginRequest(emailId = userName, password = password))
                }
            }.onSuccess {
                _showLoading.value = false
                _loginSuccess.value = true
            }.onFailure {
                _showLoading.value = false
                _loginError.value = true
            }
        }
    }

}