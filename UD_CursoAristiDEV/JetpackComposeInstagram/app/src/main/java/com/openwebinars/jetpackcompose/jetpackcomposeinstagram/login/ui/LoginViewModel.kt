package com.openwebinars.jetpackcompose.jetpackcomposeinstagram.login.ui

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel(){
    private val _email= MutableLiveData<String>()
    val email: LiveData<String> =_email

    private val _pass= MutableLiveData<String>()
    val pass: LiveData<String> =_pass

    private val _enabledLogin= MutableLiveData<Boolean>()
    val enabledLogin: LiveData<Boolean> =_enabledLogin

    fun onLoginChanged(email:String, pass:String){
        _email.value=email
        _pass.value=pass
        _enabledLogin.value = enableLogin(email,pass)
    }
    fun enableLogin(email:String, pass:String)=
        Patterns.EMAIL_ADDRESS.matcher(email).matches() && pass.length>6
}