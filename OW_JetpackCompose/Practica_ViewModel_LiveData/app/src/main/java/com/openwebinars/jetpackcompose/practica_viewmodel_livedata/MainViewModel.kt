package com.openwebinars.jetpackcompose.practica_viewmodel_livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel(){
    val textfieldNameState= MutableLiveData("") //Lo definimos como un live data directemente

    fun onTextFieldChanged(newText:String){
        textfieldNameState.value=newText //Actualizamos el estado del livedata
    }
}