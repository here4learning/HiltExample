package org.test.myapplication


import com.healthsignz.doctor.account.model.LoginRequest

interface IAccountRepository {
    suspend fun doLogin(loginRequest: LoginRequest): LoginResponse

}