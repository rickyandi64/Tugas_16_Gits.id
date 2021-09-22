package com.example.tugas_16.data.ui.single_movie_details
import androidx.lifecycle.LiveData
import com.example.tugas_16.data.api.TheMovieDBInterface
import com.example.tugas_16.data.repository.MovieDetailsNetworkDataSource
import com.example.tugas_16.data.repository.NetworkState
import com.example.tugas_16.data.vo.MovieDetails
import io.reactivex.disposables.CompositeDisposable

class MovieDetailsRepository (private val apiService : TheMovieDBInterface) {

    lateinit var movieDetailsNetworkDataSource: MovieDetailsNetworkDataSource

    fun fetchSingleMovieDetails (compositeDisposable: CompositeDisposable, movieId: Int) : LiveData<MovieDetails> {

        movieDetailsNetworkDataSource = MovieDetailsNetworkDataSource(apiService,compositeDisposable)
        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)

        return movieDetailsNetworkDataSource.downloadedMovieResponse

    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState> {
        return movieDetailsNetworkDataSource.networkState
    }



}