package org.test.myapplication

import com.healthsignz.doctor.account.model.LoginRequest
import retrofit2.http.*

interface Api {
    @POST("POZAppServices/account/login")
    suspend fun doLogin(@Body loginRequest: LoginRequest): LoginResponse


}