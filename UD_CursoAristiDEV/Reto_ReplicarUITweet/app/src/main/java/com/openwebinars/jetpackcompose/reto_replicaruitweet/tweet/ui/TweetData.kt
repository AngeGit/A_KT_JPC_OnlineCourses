package com.openwebinars.jetpackcompose.reto_replicaruitweet.tweet.ui

import com.openwebinars.jetpackcompose.reto_replicaruitweet.R

data class TweetData(
    val userIcon: Int,
    val userName: String,
    val userTweetName: String,
    val userTime: String,
    val messageData: String,
    val messageImage: Int
) {

    companion object{
        fun getDefaultData(): TweetData {
            return TweetData(
                R.drawable.profile,
                "Angie",
                "@AngeOhLala",
                "4h",
                "Compose es una combinación de 7 IDs de grupo de Maven en androidx. " +
                        "Cada grupo contiene un subconjunto de funcionalidades objetivo, " +
                        "cada uno con su propio conjunto de notas de la versión. " +
                        "En esta tabla, se explican los grupos y vínculos correspondientes a cada conjunto de notas de la versión.",
                R.drawable.profile
            )
        }
    }
}
