package com.example.androiddevchallenge.data.entity

import com.example.androiddevchallenge.R

sealed class Sex(val stringId: Int) {
    object Male: Sex(R.string.male)
    object Female: Sex(R.string.female)
}