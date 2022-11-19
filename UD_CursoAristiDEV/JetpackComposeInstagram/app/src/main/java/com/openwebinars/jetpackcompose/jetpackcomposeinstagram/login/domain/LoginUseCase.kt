package com.openwebinars.jetpackcompose.jetpackcomposeinstagram.login.domain

import com.openwebinars.jetpackcompose.jetpackcomposeinstagram.login.data.LoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repository: LoginRepository){
    //Un caso de uso puede llamar a otro caso de uso, pero lo normal es que sea el viewmodel el que llame a un caso de uso cuando se realiza una acción
    //private val repository=LoginRepository()

    suspend operator fun invoke(user:String, pass:String):Boolean{
        //Al poner el operator y el invoke nos ahorramos el tener que hacer una funcion en la que llamar en el viewmodel:
        //en lugar de usar loginUseCase("",""), tendríamos que usar loginUseCase.doLogin("","")
        return repository.doLogin(user, pass)
    }
}