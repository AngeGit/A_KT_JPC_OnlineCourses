package com.openwebinars.jetpackcompose.reto_replicaruitweet

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.openwebinars.jetpackcompose.reto_replicaruitweet.tweet.ui.TweetData

@Preview(
    name = "tweet_preview",
    showBackground = true,
    showSystemUi = true,
    device = Devices.NEXUS_5
)

@Composable
fun TweetScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF161D26))
    ){
        var data: TweetData = TweetData.getDefaultData()
        Row(
            Modifier
                .fillMaxWidth()
                .background(Color(0xFF161D26))
                .padding(16.dp),
        ) {
            UserIcon(data)
            MessageCard(data)
        }
        TweetDivider(modifier=Modifier.fillMaxWidth())
    }
}
@Composable
fun UserIcon(data: TweetData) {
    Image(
        painter = painterResource(id = data.userIcon),
        contentDescription = "User Icon",
        modifier = Modifier
            .clip(CircleShape)
            .size(55.dp)
    )
}
@Composable
fun MessageCard(data: TweetData) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        HeaderContent(data)
        BodyContent(data)
        SocialFooter(data)
    }
}
@Composable
fun HeaderContent(data: TweetData) {
    Row(modifier = Modifier.fillMaxWidth()) {
        TextContent(data.userName, Modifier.padding(end = 8.dp), Color.White, FontWeight.ExtraBold)
        TextContent(
            data.userTweetName,
            Modifier.padding(end = 8.dp),
            Color.LightGray,
            FontWeight.Normal
        )
        TextContent(data.userTime, Modifier.padding(end = 8.dp), Color.LightGray, FontWeight.Normal)
        Spacer(modifier = Modifier.weight(1f)) //Al ser el único que tiene peso, coge el espacio restante
        Icon(
            painter = painterResource(id = R.drawable.ic_dots),
            contentDescription = "More",
            tint = Color.White
        )
    }
}
@Composable
fun TextContent(title: String, modifier: Modifier, color: Color, fontWeight: FontWeight) {
    Text(
        text = title,
        color = color,
        fontWeight = fontWeight,
        modifier = modifier
    )
}
@Composable
fun BodyContent(data: TweetData) {
    TextContent(data.messageData, Modifier.padding(end = 8.dp), Color.LightGray, FontWeight.Normal)
    Image(
        painter = painterResource(id = data.messageImage),
        contentDescription = "Message Image",
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(vertical = 16.dp)
            .clip(RoundedCornerShape(50f)),
        contentScale = ContentScale.Crop
    )
}
@Composable
fun TweetDivider(modifier: Modifier) {
    Divider(
        modifier=modifier
            .padding(top=4.dp)
            .background(Color(0xFF7E8B98))
            .height(1.dp)
    )
}


