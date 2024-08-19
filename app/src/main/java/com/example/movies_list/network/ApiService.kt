package com.example.movies_list.network

import com.example.movies_list.model.MovieCategory
import retrofit2.http.GET

interface ApiService {
    @GET("movies.json")
    suspend fun getMovies(): List<MovieCategory>
}
