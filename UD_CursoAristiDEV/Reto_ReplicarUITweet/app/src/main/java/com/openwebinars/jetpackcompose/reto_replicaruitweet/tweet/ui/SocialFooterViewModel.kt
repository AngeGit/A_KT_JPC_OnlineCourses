package com.openwebinars.jetpackcompose.reto_replicaruitweet.tweet.ui


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SocialFooterViewModel: ViewModel(){
    private val _chat= MutableLiveData<Boolean>()
    val chat: LiveData<Boolean> =_chat
    fun onChatChanged(changed:Boolean){
        _chat.value=changed
    }

    private val _rt= MutableLiveData<Boolean>()
    val rt: LiveData<Boolean> =_rt
    fun onRtChanged(changed:Boolean){
        _rt.value=changed
    }

    private val _fav= MutableLiveData<Boolean>()
    val fav: LiveData<Boolean> =_fav
    fun onFavChanged(changed:Boolean){
        _fav.value=changed
    }

}