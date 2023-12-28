package com.d121211017.instagramcopy.ui.screen.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.d121211017.instagramcopy.ui.viewmodel.InstagramCopyViewModel

enum class InstagramCopyScreen(val title: String){
    Home(title = "Home Screen"),
    Explore(title = "Explore Screen"),
    Profile(title = "Profile Screen"),

}
@Composable
fun InstagramCopyApp(
    viewModel: InstagramCopyViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    navController: NavHostController = rememberNavController()
){
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = InstagramCopyScreen.valueOf(backStackEntry?.destination?.route ?: InstagramCopyScreen.Home.title)
    val uistate by viewModel.uistate.collectAsState()
}