package com.d121211017.instagramcopy.ui.viewmodel

import android.text.Spannable.Factory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import com.d121211017.instagramcopy.InstagramApplication
import com.d121211017.instagramcopy.data.repository.NetworkRepository
import com.d121211017.instagramcopy.data.repository.Repository
import com.d121211017.instagramcopy.ui.state.ExploreScreenState
import com.d121211017.instagramcopy.ui.state.HomeScreenState
import com.d121211017.instagramcopy.ui.state.ProfileScreenState
import com.d121211017.instagramcopy.ui.state.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.IOException

class InstagramCopyViewModel(private val repository: Repository): ViewModel() {
    private val _uistate = MutableStateFlow(
        UiState(
            isDarkTheme = false,
            exploreScreenState = ExploreScreenState.Loading,
            homeScreenState = HomeScreenState.Loading,
            profileScreenState = ProfileScreenState.Loading
        )
    )

    val uistate: StateFlow<UiState> = _uistate.asStateFlow()

    fun getPosts(){
        _uistate.update { currentState -> currentState.copy(homeScreenState = HomeScreenState.Loading) }
        viewModelScope.launch {
            try{
                val response = repository.getPosts()
                _uistate.update { currentState -> currentState.copy(homeScreenState = HomeScreenState.Success(posts = response)) }
            } catch (e: IOException){
                _uistate.update { currentState -> currentState.copy(homeScreenState = HomeScreenState.Failure) }
            }
        }
    }

    fun navigationFunction(navController: NavHostController, destination: String){
        navController.navigate(destination)
        println("**********************************************")
        println(navController.currentDestination?.route)
    }

    companion object{
        val Factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as InstagramApplication)
                val repository = application.container.repository
                InstagramCopyViewModel(repository)
            }
        }
    }
}