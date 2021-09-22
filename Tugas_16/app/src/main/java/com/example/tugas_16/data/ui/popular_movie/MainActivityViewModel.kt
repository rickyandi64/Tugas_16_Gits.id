package com.example.tugas_16.data.ui.popular_movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.tugas_16.data.repository.NetworkState
import com.example.tugas_16.data.vo.Movie
import io.reactivex.disposables.CompositeDisposable

class MainActivityViewModel (private val movieRespository: MoviePagedListRespository): ViewModel(){
    private val compositeDisposable = CompositeDisposable()
    val moviePagedList : LiveData<PagedList<Movie>> by lazy {
        movieRespository.fetchLiveMoviePagedList(compositeDisposable)
    }
    val networkState : LiveData<NetworkState> by lazy {
        movieRespository.getNetworkState()
    }
    fun listIsEmpty(): Boolean {
        return moviePagedList.value?.isEmpty() ?: true
    }
    override fun onCleared(){
        super.onCleared()
        compositeDisposable.dispose()
    }
}