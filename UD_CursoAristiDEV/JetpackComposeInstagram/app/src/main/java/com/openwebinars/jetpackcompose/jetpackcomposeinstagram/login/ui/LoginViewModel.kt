package com.openwebinars.jetpackcompose.jetpackcomposeinstagram.login.ui

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.openwebinars.jetpackcompose.jetpackcomposeinstagram.login.domain.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase) : ViewModel(){
    /*
        @HiltViewModel permite ser inyectado
        Para la inyección de lo que necesite el viewmodel se usa el @Inject constructor(),
        en este caso por ejemplo, el LoginUseCase
     */
    //val loginUseCase=LoginUseCase()

    private val _email= MutableLiveData<String>()
    val email: LiveData<String> =_email

    private val _pass= MutableLiveData<String>()
    val pass: LiveData<String> =_pass

    private val _enabledLogin= MutableLiveData<Boolean>()
    val enabledLogin: LiveData<Boolean> =_enabledLogin



    private val _isLoading= MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> =_isLoading

    fun onLoginChanged(email:String, pass:String){
        _email.value=email
        _pass.value=pass
        _enabledLogin.value = enableLogin(email,pass)
    }

    fun enableLogin(email:String, pass:String)=
        Patterns.EMAIL_ADDRESS.matcher(email).matches() && pass.length>6

    fun onLoginSelected(){
        viewModelScope.launch {
            _isLoading.value=true
            val resultado=loginUseCase(email.value!!,pass.value!!)
            Log.i("LoginViewModel", "onLoginSelected()=>result=$resultado")
            if(resultado){
                //Navegar a la siguiente pantalla
            }
            _isLoading.value=false
        }
    }
}