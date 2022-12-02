package com.openwebinars.jetpackcompose.componentscatalog.models

sealed class Routes(val route:String){
    object Pantalla1: Routes("pantalla1")
    object Pantalla2: Routes("pantalla2")
    object Pantalla3: Routes("pantalla3")
    object Pantalla4: Routes("pantalla4/{name}/{num}") {//Param obligatorio para pantalla 4
        fun createRoute4(name:String, num:Int)="pantalla4/$name/$num"
    }
    object Pantalla5: Routes("pantalla5?name={name}"){//Param opcional para pantalla 5
        fun createRoute5(name:String)="pantalla5?name=$name"
    }
}
