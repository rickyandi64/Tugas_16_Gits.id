package com.example.tugas_16.data.api

import com.example.tugas_16.data.ui.MovieResponse
import com.example.tugas_16.data.vo.MovieDetails
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TheMovieDBInterface {
    // https://api.themoviedb.org/3/movie/597891?api_key=60dc71cfdc0a65403f47ce2836f4b4bc
    // https://api.themoviedb.org/3/movie/popular?api_key=60dc71cfdc0a65403f47ce2836f4b4bc
    // https://api.themoviedb.org/3/

    @GET("movie/popular")
    fun getPopularMovie(@Query("page") page: Int): Single<MovieResponse>

    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id")id:Int): Single<MovieDetails>
}