package com.openwebinars.jetpackcompose.jetpackcomposeinstagram.core.di

import com.openwebinars.jetpackcompose.jetpackcomposeinstagram.login.data.network.LoginClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) //Scope/alcance a nivel de aplicación
class NetworkModule {
    @Singleton //Patrón singleton, para que sólo sea una sola instancia
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://run.mocky.io/")
            .addConverterFactory(GsonConverterFactory.create())//Convierte el json que nos viene en la dataclass
            .build()
    }
    @Singleton
    @Provides
    fun provideLoginClient(retrofit: Retrofit):LoginClient {
       return retrofit.create(LoginClient::class.java)
    }
}