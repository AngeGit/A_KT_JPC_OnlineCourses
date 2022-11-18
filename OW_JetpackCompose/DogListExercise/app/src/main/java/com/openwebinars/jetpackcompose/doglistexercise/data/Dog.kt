package com.openwebinars.jetpackcompose.doglistexercise.data

data class Dog(
    val name:String,
    val breed:String,
    val age:Int,
    val imageUrl:String
){
    fun getDogImageDescription()= "Este perro se llama ${name}, es de raza ${breed}y tiene ${age}"+ (if(age==1) "año" else "años")
}
