package com.openwebinars.jetpackcompose.jetpackcomposeinstagram.login.data.network

import com.openwebinars.jetpackcompose.jetpackcomposeinstagram.core.network.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

import javax.inject.Inject

class LoginService @Inject constructor(private val loginClient: LoginClient) {
    //Clase que implementa la interfaz de LoginClient, y que va a ser la encargada de llamar a los endpoints del cliente. Tambien es la que tiene la instancia del objeto retrofit.
    //val retrofit=RetrofitHelper.getRetrofit()

    suspend fun doLogin(user:String, pass:String):Boolean{
        //Las corrutinas las usamos para crear hilos secundarios y no sobrecargar el hilo principal (el MAIN), que guarden, consuman datos etc.
        //Para persistencia de datos y demás usamos IO.
       return  withContext(Dispatchers.IO){
           //val response= retrofit.create(LoginClient::class.java).doLogin(user,pass)
           val response= loginClient.doLogin()
            //Técnicamente, lo ideal sería que la dataclass de respuesta de data y la del dominio fueran diferentes
            response.body()?.success ?:false
        }

    }
}