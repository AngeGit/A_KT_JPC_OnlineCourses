package com.openwebinars.jetpackcompose.jetpackcomposeinstagram

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//Para inicializarla hay que meter el name de la app en el Manifest:
// android:name=".JetpackComposeInstagramApp"
@HiltAndroidApp
class JetpackComposeInstagramApp : Application() {
    /*
    Activities=> Anotación @AndroidEntryPoint
    ViewModels=> Anotación @HiltViewModel
    Clases que no son Activities o ViewModels=> Inyectando el constructor=> Anotación @InjectConstructor
    Clases de libs o que contengan interfaces=> A través de un provider
     */
}