package com.example.androiddevchallenge.data.entity

sealed class Temper {
    object Aggressive: Temper()
    object Wild: Temper()
    object Shy: Temper()
    object Tame: Temper()
}