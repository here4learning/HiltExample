package com.healthsignz.doctor.account.model

data class LoginRequest(
    var otp: String? = null,
    var emailId: String? = null,
    var password: String? = null
)