package com.example.androiddevchallenge.ui.navigation

import android.os.Parcelable
import androidx.compose.runtime.mutableStateOf
import kotlinx.parcelize.Parcelize

object Navigator {

    val currentDestination = mutableStateOf<Destination>(Destination.Home)

    fun navigateToDetail(parrotId: Int) {
        currentDestination.value = Destination.Detail(parrotId)
    }

    fun back() {
        currentDestination.value = Destination.Home
    }

    sealed class Destination : Parcelable {
        @Parcelize
        object Home : Destination()

        @Parcelize
        class Detail(val parrotId: Int) : Destination()
    }
}