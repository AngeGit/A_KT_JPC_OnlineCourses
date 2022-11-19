package com.openwebinars.jetpackcompose.jetpackcomposeinstagram.login.data

import com.openwebinars.jetpackcompose.jetpackcomposeinstagram.login.data.network.LoginService
import javax.inject.Inject

class LoginRepository @Inject constructor(private val api: LoginService) {
    //El repositorio es la clase que se encarga de decidir a dónde se piden los datos.
    //private val api=LoginService()

    suspend fun doLogin(user:String, pass:String):Boolean{
        //aquí sería dónde se hacen comprobaciones. Por ejemplo, miramos si el user está guardado en bd y si no lo pedimos por sw
       return api.doLogin(user,pass)
    }

}