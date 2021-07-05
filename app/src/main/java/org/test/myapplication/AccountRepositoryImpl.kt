package org.test.myapplication

import com.healthsignz.doctor.account.model.LoginRequest

import javax.inject.Inject

class AccountRepositoryImpl @Inject constructor(private val api: Api,private val preferences: Preferences) : IAccountRepository {
    override suspend fun doLogin(loginRequest: LoginRequest): LoginResponse {
        return api.doLogin(loginRequest)
    }

}
