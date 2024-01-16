package com.d121211017.instagramcopy.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.d121211017.instagramcopy.R
import com.d121211017.instagramcopy.data.model.postsItem

@Composable
fun Post(post: postsItem){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp)) {
        PostHeader(post = post)
        PostImage()
        PostDescription(post = post)
    }
}

@Composable
fun PostHeader(post: postsItem, modifier: Modifier = Modifier){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Row{
            Box(
                modifier = modifier
                    .size(32.dp)
                    .border(
                        border = BorderStroke(width = 1.dp, color = Color.Black),
                        shape = CircleShape
                    )
            ) {

            }
            Spacer(modifier = modifier.width(16.dp))
            Text(post.name)
        }
        IconButton(
            onClick = { /*TODO*/ }
        ) {
            Icon(
                painter = painterResource(
                    id = R.drawable.explore),
                contentDescription = "More Button"
            )
        }
    }
}

@Composable
fun PostImage(modifier: Modifier = Modifier){
    Box(modifier = modifier.height(250.dp).fillMaxWidth()) {
        Image(
            painter = painterResource(id = R.drawable.mockup),
            contentDescription = "Post Image",
            contentScale = ContentScale.FillBounds
        )
    }
}

@Composable
fun PostDescription(post: postsItem){
    Column {
        Row {
            Icon(painter = painterResource(id = R.drawable.favorite), contentDescription = "Like Button")
            Spacer(modifier = Modifier.width(16.dp))
            Icon(painter = painterResource(id = R.drawable.favorite), contentDescription = "Comment Button")
            Spacer(modifier = Modifier.width(16.dp))
            Icon(painter = painterResource(id = R.drawable.favorite), contentDescription = "Share Button")
            Spacer(modifier = Modifier.width(16.dp))
        }
        Row(){
            Text(post.name, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.width(8.dp))
            Text(post.deskripsi)
        }
    }
}