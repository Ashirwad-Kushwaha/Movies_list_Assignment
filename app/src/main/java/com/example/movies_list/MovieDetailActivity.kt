package com.example.movies_list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.movies_list.databinding.ActivityMovieDetailBinding
import com.example.movies_list.model.Movie

class MovieDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movie = intent.getParcelableExtra("movie", Movie::class.java)
        movie?.let {
            binding.tvMovieTitleDetail.text = it.title
            binding.tvMovieReleaseDateDetail.text = "Release Date: ${it.releaseDate}"
            binding.tvMovieCastDetail.text = "Cast: ${it.actors}"
            binding.tvMovieDescriptionDetail.text = it.storyline

            Glide.with(this)
                .load(it.posterUrl)
                .into(binding.ivMoviePosterDetail)
        }
    }
}