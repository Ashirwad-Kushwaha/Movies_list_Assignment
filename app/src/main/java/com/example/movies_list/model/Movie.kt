package com.example.movies_list.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
val id: String,
val title: String,
val year: String,
val genres: String,
val poster: String,
val contentRating: String,
val duration: String,
val releaseDate: String,
val averageRating: Double,
val originalTitle: String,
val storyline: String,
val actors: String,
val imdbRating: Double,
val posterUrl: String
) : Parcelable