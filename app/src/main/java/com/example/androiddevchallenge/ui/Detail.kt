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
package com.example.androiddevchallenge.ui

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Cancel
import androidx.compose.material.icons.outlined.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.palette.graphics.Palette
import com.example.androiddevchallenge.data.entity.Parrot
import com.example.androiddevchallenge.ui.navigation.Navigator
import com.example.androiddevchallenge.ui.theme.green
import com.example.androiddevchallenge.ui.theme.red

@Composable
fun ParrotDetail(parrotId: Int) {
    Surface(
        Modifier
            .background(red)
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        val viewModel = viewModel(ParrotViewModel::class.java)
        val viewState by viewModel.state.collectAsState()

        viewModel.getParrotById(parrotId)

        viewState.parrot?.let { DisplayParrotData(it) }
    }
}

@Composable
private fun DisplayParrotData(parrot: Parrot) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Navigation()
        Header(parrot = parrot)
        ParrotInfo(parrot = parrot)
    }
}

@Composable
private fun Navigation() {
    IconButton(
        onClick = { Navigator.back() },
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .size(36.dp)
    ) {
        Icon(imageVector = Icons.Outlined.ArrowBack, contentDescription = "")
    }
}

@Composable
private fun Header(parrot: Parrot) {
    val bitmap = LocalContext.current.assets.open(parrot.picture)
        .let { BitmapFactory.decodeStream(it) }
    val palette = Palette.Builder(bitmap).generate()
    val cardBackgroundColor = Color(palette.vibrantSwatch?.rgb ?: 0x000000)
        .copy(alpha = 0.12f)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .background(cardBackgroundColor)
    ) {
        Image(
            bitmap = bitmap.asImageBitmap(),
            contentDescription = "",
            modifier = Modifier.fillMaxWidth(0.5f),
            contentScale = ContentScale.FillWidth,
        )
    }
}

@Composable
private fun ParrotInfo(parrot: Parrot) {
    Column(
        modifier = Modifier
            .padding(12.dp)
            .verticalScroll(rememberScrollState()),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalAlignment = CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(top = 4.dp),
                text = parrot.breed,
                style = MaterialTheme.typography.h6,
            )
            Text(
                text = LocalContext.current.getString(parrot.sex.stringId),
                style = MaterialTheme.typography.subtitle2,
            )
            Text(
                text = parrot.latinName,
                style = MaterialTheme.typography.subtitle2,
            )
        }
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = "Favorite Song",
                style = MaterialTheme.typography.body1,
            )
            Text(
                text = parrot.favSongToSing,
//                modifier = Modifier.padding(start = 8.dp),
                style = MaterialTheme.typography.body2,
            )
        }
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = "Favorite place to chill",
                style = MaterialTheme.typography.body1,
            )
            Text(
                text = parrot.favPlaceToChill,
//                modifier = Modifier.padding(start = 8.dp),
                style = MaterialTheme.typography.body2,
            )
        }
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = "Age",
                style = MaterialTheme.typography.body1,
            )
            Text(
                text = parrot.age.toString(),
                style = MaterialTheme.typography.body2,
            )
        }
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = "Top Speed",
                style = MaterialTheme.typography.body1,
            )
            Text(
                text = "${parrot.topSpeed} m/s",
                style = MaterialTheme.typography.body2,
            )
        }
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = "Length",
                style = MaterialTheme.typography.body1,
            )
            Text(
                text = "${parrot.length} cm",
                style = MaterialTheme.typography.body2,
            )
        }
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = "Leg Band",
                style = MaterialTheme.typography.body1,
            )
            if (parrot.legBand) {
                Icon(imageVector = Icons.Outlined.Check, contentDescription = "", tint = green)
            } else {
                Icon(imageVector = Icons.Outlined.Cancel, contentDescription = "", tint = red)
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalAlignment = CenterHorizontally
        ) {
            Button(onClick = { /*TODO*/ }) {
                Text(
                    text = "Adopt",
                    style = MaterialTheme.typography.body1,
                )
            }
        }
    }
}
