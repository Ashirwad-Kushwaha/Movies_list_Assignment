package com.example.movies_list

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies_list.adapter.MovieCategoryAdapter
import com.example.movies_list.databinding.ActivityMainBinding
import com.example.movies_list.model.MovieCategory
import com.example.movies_list.network.RetrofitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.rvCategories.layoutManager = LinearLayoutManager(this)

        CoroutineScope(Dispatchers.IO).launch {
            val movieCategories = loadMoviesFromJson()
            withContext(Dispatchers.Main) {
                binding.rvCategories.adapter = MovieCategoryAdapter(movieCategories) { movie ->
                    val intent = Intent(this@MainActivity, MovieDetailActivity::class.java)
                    intent.putExtra("movie", movie)
                    startActivity(intent)
                }
            }
        }
    }

    private suspend fun loadMoviesFromJson(): List<MovieCategory> {
        return RetrofitInstance.apiService.getMovies()
    }
}