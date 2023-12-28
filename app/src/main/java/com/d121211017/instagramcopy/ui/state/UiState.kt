package com.d121211017.instagramcopy.ui.state

import com.d121211017.instagramcopy.data.model.posts

sealed interface HomeScreenState{
    object Loading: HomeScreenState

    object Failure: HomeScreenState

    data class Success(val posts: posts): HomeScreenState
}

sealed interface ExploreScreenState{
    object Loading: ExploreScreenState

    object Failure: ExploreScreenState

    data class Success(val posts: posts): ExploreScreenState
}

sealed interface ProfileScreenState{
    object Loading: ProfileScreenState
    object Failure: ProfileScreenState
    object Success:ProfileScreenState
}

data class UiState(
    val isDarkTheme: Boolean = false,
    val homeScreenState: HomeScreenState,
    val exploreScreenState: ExploreScreenState,
    val profileScreenState: ProfileScreenState
)