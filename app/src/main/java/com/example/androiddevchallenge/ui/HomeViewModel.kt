package com.example.androiddevchallenge.ui

import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.data.DataProvider
import com.example.androiddevchallenge.data.entity.Parrot
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel : ViewModel() {
    private val _state = MutableStateFlow(HomeViewState())

    val state: StateFlow<HomeViewState>
        get() = _state

    data class HomeViewState(val parrots: List<Parrot> = DataProvider.getData())
}