package com.example.androiddevchallenge.ui

import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.data.DataProvider
import com.example.androiddevchallenge.data.entity.Parrot
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ParrotViewModel : ViewModel() {
    private val _state = MutableStateFlow(ParrotViewState())

    val state: StateFlow<ParrotViewState>
        get() = _state

    fun getParrotById(id: Int) {
        _state.value = ParrotViewState(DataProvider.getData().find { it.id == id })
    }

    data class ParrotViewState(val parrot: Parrot? = null)
}