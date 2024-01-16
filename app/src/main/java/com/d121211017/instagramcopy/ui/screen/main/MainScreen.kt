package com.d121211017.instagramcopy.ui.screen.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.d121211017.instagramcopy.R
import com.d121211017.instagramcopy.ui.screen.home.HomeScreen
import com.d121211017.instagramcopy.ui.state.UiState
import com.d121211017.instagramcopy.ui.theme.InstagramCopyTheme
import com.d121211017.instagramcopy.ui.viewmodel.InstagramCopyViewModel

enum class InstagramCopyScreen(val title: String){
    Home(title = "Home Screen"),
    Explore(title = "Explore Screen"),
    Profile(title = "Profile Screen"),
    Notifications(title = "Notification Screen"),
    Contact(title = "Contact Screen"),
    Message(title = "Message Screen")
}
@Composable
fun InstagramCopyApp(
    viewModel: InstagramCopyViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    navController: NavHostController = rememberNavController()
){
    val uistate by viewModel.uistate.collectAsState()
    InstagramCopyScaffold(
        navController = navController,
        viewModel = viewModel,
        uiState = uistate)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun InstagramCopyScaffold(
    navController: NavHostController,
    viewModel: InstagramCopyViewModel,
    uiState: UiState,
    modifier: Modifier = Modifier
){
    Scaffold(
        topBar = {
            InstagramCopyTopBar(
                navController = navController,
                viewModel = viewModel
            )
                 },
        bottomBar = {
            InstagramCopyBottomBar(
                navController = navController
            )
        }

    ) {it ->
        NavHost(
            navController = navController,
            startDestination = InstagramCopyScreen.Home.name,
            modifier = modifier.padding(it).fillMaxSize()){
            composable(InstagramCopyScreen.Home.name){
                HomeScreen(modifier = Modifier.fillMaxSize())
            }
            composable(InstagramCopyScreen.Explore.name){
                Text("Explore")
            }
            composable(InstagramCopyScreen.Profile.name){
                Text("Profile")
            }
            composable(InstagramCopyScreen.Notifications.name){
                Text("Notification")
            }
            composable(InstagramCopyScreen.Contact.name){
                Text("Contact")
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InstagramCopyTopBar(
    modifier: Modifier = Modifier,
    viewModel: InstagramCopyViewModel,
    navController: NavHostController
) {
    TopAppBar(
        title = {
            Text("Instagram")
        },
        actions = {
            Row{
                IconButton(
                    onClick = {viewModel.navigationFunction(navController = navController, destination = InstagramCopyScreen.Notifications.name) }
                ) {
                    Icon(painterResource(id = R.drawable.favorite), contentDescription = "Favorite Button")
                }
                IconButton(
                    onClick = { viewModel.navigationFunction(navController = navController, destination = InstagramCopyScreen.Contact.name) }
                ) {
                    Icon(painterResource(id = R.drawable.chat), contentDescription = "Chat Button")
                }
            } }
    )
}

@Composable
fun InstagramCopyBottomBar(
    modifier: Modifier = Modifier,
    navController: NavHostController,
){
    BottomAppBar(modifier = modifier.fillMaxWidth(), contentPadding = PaddingValues(0.dp)) {
        Row(modifier = modifier
            .fillMaxWidth()
            .padding(0.dp) ,horizontalArrangement = Arrangement.SpaceEvenly){
            IconButton(onClick = { navController.navigate(InstagramCopyScreen.Home.name) }){
                Icon(painter = painterResource(id = R.drawable.home), contentDescription = "Home Button")
            }
            IconButton(onClick = { navController.navigate(InstagramCopyScreen.Explore.name) }) {
                Icon(painter = painterResource(id = R.drawable.explore), contentDescription = "Explore Button")
            }
            IconButton(onClick = {navController.navigate(InstagramCopyScreen.Profile.name)}) {
                Icon(painter = painterResource(id = R.drawable.person), contentDescription = "Profile Button")
            }
        }
    }
}

@Preview
@Composable
fun Preview(){
    InstagramCopyTheme {
        InstagramCopyApp()
    }
}