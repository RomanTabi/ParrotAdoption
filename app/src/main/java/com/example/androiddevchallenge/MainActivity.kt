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
package com.example.androiddevchallenge

import android.content.res.Configuration
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.palette.graphics.Palette
import com.example.androiddevchallenge.data.DataProvider
import com.example.androiddevchallenge.data.entity.Parrot
import com.example.androiddevchallenge.ui.HomeViewModel
import com.example.androiddevchallenge.ui.ParrotDetail
import com.example.androiddevchallenge.ui.navigation.Navigator
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.black
import com.example.androiddevchallenge.ui.theme.orange
import com.example.androiddevchallenge.ui.theme.white

class MainActivity : AppCompatActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.statusBarColor = white.toArgb()
        window.decorView.systemUiVisibility = window.decorView.systemUiVisibility or
            View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        setContent {
            MyTheme {
                val destination = rememberSaveable { Navigator.currentDestination }

                when (destination.value) {
                    is Navigator.Destination.Home -> Home()
                    is Navigator.Destination.Detail ->
                        ParrotDetail((destination.value as Navigator.Destination.Detail).parrotId)
                }
            }
        }
    }
}

// Start building your app here!
@ExperimentalFoundationApi
@Composable
fun Home() {
    Surface(color = MaterialTheme.colors.background) {
        Column {
            Header()

            val viewModel = viewModel(HomeViewModel::class.java)
            val viewState = viewModel.state.collectAsState()

            ListParrots(viewState.value.parrots)
        }
    }
}

@Composable
fun Header() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Title()
            Row(verticalAlignment = CenterVertically) {
                Column(modifier = Modifier.fillMaxWidth(0.8f)) {
                    Location()
                    BreedFilter()
                }
                Column {
                    Button(
                        onClick = {},
                        shape = MaterialTheme.shapes.medium
                    ) {
                        Text(
                            text = LocalContext.current.getString(R.string.filter),
                            style = MaterialTheme.typography.body1,
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Title() {
    Column(
        horizontalAlignment = CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = LocalContext.current.getString(R.string.adopt_parrot),
            style = MaterialTheme.typography.h5,
        )
    }
}

@Composable
fun BreedFilter() {
    Column(
        horizontalAlignment = CenterHorizontally,
        modifier = Modifier
            .padding(top = 8.dp)
            .fillMaxWidth()
    ) {
        LazyRow {
            val breeds = listOf("Cockatiel", "Macaw", "Kea", "Parakeet")
            items(breeds) { breed ->
                Breed(breed = breed)
            }
        }
    }
}

@Composable
fun Breed(breed: String) {
    Surface(
        modifier = Modifier.padding(4.dp),
        shape = MaterialTheme.shapes.large,
    ) {
        Text(
            modifier = Modifier
                .background(orange.copy(alpha = 0.2f))
                .padding(8.dp),
            text = breed,
            style = MaterialTheme.typography.subtitle2,
        )
    }
}

@Composable
fun Location() {
    Column(
        horizontalAlignment = CenterHorizontally,
        modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "Brno, Czech Republic",
            style = MaterialTheme.typography.body1,
        )
        Row(verticalAlignment = CenterVertically) {
            Icon(
                imageVector = Icons.Outlined.LocationOn,
                contentDescription = "",
                modifier = Modifier
                    .size(12.dp),
            )
            Text(
                text = LocalContext.current.getString(R.string.location),
                style = MaterialTheme.typography.subtitle2,
                modifier = Modifier.padding(start = 4.dp)
            )
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun ListParrots(parrots: List<Parrot>) {
    val orientation = LocalContext.current.resources.configuration.orientation
    val cellCount = if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
        4
    } else {
        2
    }
    Column {
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp),
            color = black.copy(alpha = 0.1f)
        )
        LazyVerticalGrid(cells = GridCells.Fixed(cellCount)) {
            items(parrots) { parrot ->
                ParrotItem(parrot = parrot)
            }
        }
    }
}

@Composable
fun ParrotItem(parrot: Parrot) {
    val bitmap = LocalContext.current.assets.open(parrot.picture)
        .let { BitmapFactory.decodeStream(it) }
    val palette = Palette.Builder(bitmap).generate()
    val cardBackgroundColor = Color(palette.vibrantSwatch?.rgb ?: 0x000000).copy(alpha = 0.12f)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        shape = MaterialTheme.shapes.large,
    ) {
        Surface(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .clickable {
                    Navigator.navigateToDetail(parrot.id)
                }
        ) {
            Column(
                modifier = Modifier
                    .background(cardBackgroundColor)
                    .padding(12.dp),
            ) {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(196.dp),
                    shape = MaterialTheme.shapes.large,
                ) {
                    Image(
                        bitmap = bitmap.asImageBitmap(),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                    )
                }
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
        }
    }
}

@Preview("Parrot Preview")
@Composable
fun ParrotPreview() {
    ParrotItem(parrot = DataProvider.getData().first())
}

@Preview("Header")
@Composable
fun HeaderPreview() {
    Header()
}

@ExperimentalFoundationApi
@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        ListParrots(DataProvider.getData())
    }
}
