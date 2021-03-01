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
package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.data.entity.Parrot
import com.example.androiddevchallenge.data.entity.Sex
import com.example.androiddevchallenge.data.entity.Temper

object DataProvider {

    fun getData(): List<Parrot> = listOf(
        Parrot(
            0,
            "Billy",
            "Brno CZ",
            Temper.Tame,
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
            "Sunflower seeds",
            "Mom's hair",
            "Jon Bon Jovi - Livin' on a prayer",
            6,
            "hyacinth_macaw.jpeg",
            17,
            1.5f,
            "Hyacinth Macaw",
            "Anodorhynchus hyacinthinus",
            Sex.Male,
            false,
            100,
            1500f,
        ),
        Parrot(
            1,
            "Lisa",
            "Zlin CZ",
            Temper.Wild,
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
            "Sunflower seeds",
            "Mom's hair",
            "Jon Bon Jovi - Livin' on a prayer",
            3,
            "rosy_faced_lovebird.jpg",
            17,
            1.5f,
            "Rosy Faced Lovebird",
            "Agapornis roseicollis",
            Sex.Female,
            true,
            17,
            50f,
        ),
        Parrot(
            2,
            "Lisa",
            "Zlin CZ",
            Temper.Wild,
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
            "Sunflower seeds",
            "Mom's hair",
            "Jon Bon Jovi - Livin' on a prayer",
            3,
            "kea.jpg",
            17,
            1.5f,
            "Kea",
            "Nestor notabilis",
            Sex.Female,
            false,
            48,
            800f,
        ),
        Parrot(
            3,
            "Lisa",
            "Zlin CZ",
            Temper.Wild,
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
            "Sunflower seeds",
            "Mom's hair",
            "Jon Bon Jovi - Livin' on a prayer",
            3,
            "blue_crowned_parakeet.jpg",
            17,
            1.5f,
            "Blue Crowned Parakeet",
            "Thectocercus acuticaudatus",
            Sex.Male,
            false,
            32,
            150f,
        ),
        Parrot(
            4,
            "Lisa",
            "Zlin CZ",
            Temper.Wild,
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
            "Sunflower seeds",
            "Mom's hair",
            "Jon Bon Jovi - Livin' on a prayer",
            3,
            "cockatiel.jpg",
            17,
            1.5f,
            "Cockatiel",
            "Nymphicus hollandicus",
            Sex.Female,
            false,
            32,
            90f,
        ),
    )
}
