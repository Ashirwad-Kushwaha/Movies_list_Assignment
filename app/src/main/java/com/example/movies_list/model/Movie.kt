package com.example.movies_list.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
val id: String,
val title: String,
val year: String,
val genres: String,
val duration: String,
val releaseDate: String,
val storyline: String,
val actors: String,
val imdbRating: Double,
val posterUrl: String
) : Parcelable