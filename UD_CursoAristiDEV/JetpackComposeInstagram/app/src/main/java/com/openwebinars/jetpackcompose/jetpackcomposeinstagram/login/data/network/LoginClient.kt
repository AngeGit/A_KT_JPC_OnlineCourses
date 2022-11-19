package com.openwebinars.jetpackcompose.jetpackcomposeinstagram.login.data.network

import com.openwebinars.jetpackcompose.jetpackcomposeinstagram.login.data.network.response.LoginResponse
import retrofit2.Response
import retrofit2.http.GET

interface LoginClient { //Interfaz que va a consumir los endpoints
    @GET("/v3/f78c9d33-28b1-4f81-9cf1-6d6ff78fa014")
  //  suspend fun doLogin(user:String, pass:String):Response<LoginResponse> Al no pasarle los params a la ruta peta X'D
    suspend fun doLogin():Response<LoginResponse>
}