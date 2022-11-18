package com.openwebinars.jetpackcompose.reto_replicaruitweet

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.openwebinars.jetpackcompose.reto_replicaruitweet.tweet.ui.SocialFooterViewModel
import com.openwebinars.jetpackcompose.reto_replicaruitweet.tweet.ui.TweetData

@Composable
fun SocialFooter(data: TweetData, viewModel: SocialFooterViewModel = SocialFooterViewModel()) {
    Row(modifier = Modifier.fillMaxWidth()) {
        CommentIcon(modifier = Modifier.weight(1f), viewModel)
        RtIcon(modifier = Modifier.weight(1f), viewModel)
        FavIcon(modifier = Modifier.weight(1f), viewModel)
    }
}

//region Comment Icon
@Composable
fun CommentIcon(
    modifier: Modifier,
    viewModel: SocialFooterViewModel
) {
    val chatState: Boolean by viewModel.chat.observeAsState(false)
    SocialIcon(
        modifier = modifier,
        unselectedIcon = {
            UnSelectedCommentIcon()
        },
        selectedIcon = {
            SelectedCommentIcon()
        },
        chatState,
        { viewModel.onChatChanged(!chatState) }
    )
}
@Composable
fun UnSelectedCommentIcon() {
    Icon(
        painter = painterResource(id = R.drawable.ic_chat),
        contentDescription = "Chat Icon",
        tint = Color(0xFF7E8B98)
    )
}
@Composable
fun SelectedCommentIcon() {
    Icon(
        painter = painterResource(id = R.drawable.ic_chat_filled),
        contentDescription = "Chat Filled Icon",
        tint = Color(0xFF7E8B98)
    )
}
//endregion Comment Icon
//region RT Icon
@Composable
fun RtIcon(
    modifier: Modifier,
    viewModel: SocialFooterViewModel
) {
    val rtState : Boolean by viewModel.rt.observeAsState(true)
    SocialIcon(
        modifier = modifier,
        unselectedIcon = {
            UnSelectedRtIcon()
        },
        selectedIcon = {
            SelectedRtIcon()
        },
       rtState,
        { viewModel.onRtChanged(!rtState) }
    )
}

@Composable
fun UnSelectedRtIcon() {
    Icon(
        painter = painterResource(id = R.drawable.ic_rt),
        contentDescription = "Rt Icon",
        tint = Color(0xFF7E8B98)
    )
}

@Composable
fun SelectedRtIcon() {
    Icon(
        painter = painterResource(id  = R.drawable.ic_rt),
        contentDescription = "RtFilled Icon",
        tint = Color.Green
    )
}
//endregion Comment Icon
//region Fav Icon
@Composable
fun FavIcon(
    modifier: Modifier,
    viewModel: SocialFooterViewModel
) {
    val favState : Boolean by viewModel.fav.observeAsState(true)
    SocialIcon(
        modifier = modifier,
        unselectedIcon = {
            UnSelectedFavIcon()
        },
        selectedIcon = {
            SelectedFavIcon()
        },
        favState,
        { viewModel.onFavChanged(!favState) }
    )
}

@Composable
fun UnSelectedFavIcon() {
    Icon(
        painter = painterResource(id = R.drawable.ic_like),
        contentDescription = "Fav Icon",
        tint = Color(0xFF7E8B98)
    )
}

@Composable
fun SelectedFavIcon() {
    Icon(
        painter = painterResource(id  = R.drawable.ic_like_filled),
        contentDescription = "Fav Filled Icon",
        tint = Color.Red
    )
}
//endregion FavIcon


@Composable
fun SocialIcon(
    modifier: Modifier,
    unselectedIcon: @Composable () -> Unit,
    selectedIcon: @Composable () -> Unit,
    isSelected: Boolean,
    onItemSelected: () -> Unit
) {
    val defaultValue = 1
    Row(
        modifier = modifier.clickable { onItemSelected() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (isSelected) {
            selectedIcon()
        } else {
            unselectedIcon()
        }
        Text(
            text = if (isSelected) (defaultValue + 1).toString() else defaultValue.toString(),
            color = Color(0xFF7E8B98),
            fontSize = 12.sp,
            modifier = Modifier.padding(start = 4.dp)
        )
    }
}