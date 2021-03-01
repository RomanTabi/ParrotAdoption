/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.data.entity

data class Parrot(
    val id: Int,
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
