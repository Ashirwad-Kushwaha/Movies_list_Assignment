package com.example.movies_list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movies_list.databinding.ItemMovieCategoryBinding
import com.example.movies_list.model.Movie
import com.example.movies_list.model.MovieCategory


class MovieCategoryAdapter(
    private val categories: List<MovieCategory>,
    private val onMovieClick: (Movie) -> Unit
) : RecyclerView.Adapter<MovieCategoryAdapter.CategoryViewHolder>() {

    inner class CategoryViewHolder(private val binding: ItemMovieCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(category: MovieCategory) {
            binding.tvCategoryTitle.text = category.category
            binding.rvMovies.layoutManager = LinearLayoutManager(
                binding.rvMovies.context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            binding.rvMovies.adapter = MovieAdapter(category.movies, onMovieClick)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = ItemMovieCategoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categories[position])
    }

    override fun getItemCount(): Int = categories.size
}