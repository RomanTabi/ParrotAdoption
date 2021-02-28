package com.example.androiddevchallenge.data.entity

data class Parrot(
    val name: String,
    val location: String,
    val temper: Temper,
    val description: String,
    val favFood: String,
    val favPlaceToChill: String,
    val favSongToSing: String,
    val age: Int,
    val picture: String,
    val longestFlight: Int, // in meters
    val topSpeed: Float, // in m/s
    val breed: String,
    val latinName: String,
    val sex: Sex,
    val legBand: Boolean,
    val length: Int,
    val weight: Float,
)