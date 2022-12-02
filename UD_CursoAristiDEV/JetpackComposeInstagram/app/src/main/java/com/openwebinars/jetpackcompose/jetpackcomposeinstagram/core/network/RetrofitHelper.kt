package com.openwebinars.jetpackcompose.jetpackcomposeinstagram.core.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    //Permite crear una instancia de Retrofit que es la que vamos a usar en el proyecto para consumir las APIs
    //------------------------ Con inyeccion de dependencias esta clase queda obsoleta ------------------------------------
    fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://run.mocky.io/")
            .addConverterFactory(GsonConverterFactory.create())//Convierte el json que nos viene en la dataclass
            .build()
    }

}