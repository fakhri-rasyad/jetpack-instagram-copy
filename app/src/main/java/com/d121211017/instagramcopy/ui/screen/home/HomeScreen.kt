package com.d121211017.instagramcopy.ui.screen.home

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.d121211017.instagramcopy.data.model.postsItem
import com.d121211017.instagramcopy.ui.component.Post

@Composable
fun HomeScreen(modifier: Modifier = Modifier){
    val example = postsItem(
        date_created = "Now",
        deskripsi = "Lorem Ipsum Si Amet",
        id = "10",
        image = "",
        likes = 200,
        name = "Test Name",
        profile_picture = "Check"
    )
    
    LazyColumn(modifier = modifier.fillMaxWidth()){
        items(5){
            _ ->
            Post(post = example)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}