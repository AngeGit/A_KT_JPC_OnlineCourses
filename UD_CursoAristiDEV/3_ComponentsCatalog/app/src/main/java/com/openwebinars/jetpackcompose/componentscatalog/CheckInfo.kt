package com.openwebinars.jetpackcompose.componentscatalog

data class CheckInfo(
    val title:String,
    var selected:Boolean=false,
    var onCheckedChange:(Boolean)->Unit
)
