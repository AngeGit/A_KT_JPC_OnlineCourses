package com.jetpackcompose.todoapp.addtasks.data.di

import android.content.Context
import androidx.room.Room
import com.jetpackcompose.todoapp.addtasks.data.TaskDao
import com.jetpackcompose.todoapp.addtasks.data.TaskDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    //Proveedor de la interfaz del DAO, para la "gestión" de la bd
    @Provides
    fun provideTasDao(db:TaskDatabase):TaskDao{
        return db.taskDao()
    }
    //Proveedor de lo que es la base de datos(constructor singleton para que sólo haya una instancia de la bd)
    @Provides
    @Singleton
    fun provideTaskDatabase(@ApplicationContext appContext: Context):TaskDatabase{
        //Creamos la bd;
        return Room.databaseBuilder(appContext,TaskDatabase::class.java,"TaskDB").build()
    }

}