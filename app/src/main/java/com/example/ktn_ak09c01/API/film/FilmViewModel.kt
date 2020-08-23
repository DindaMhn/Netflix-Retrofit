package com.example.ktn_ak09c01.API.film

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ktn_ak09c01.config.RetrofitBuilder

class FilmViewModel : ViewModel() {
    val filmRepository: FilmRepository

    init {
        val filmAPI = RetrofitBuilder.createRetrofit().create(FilmAPI::class.java)
        filmRepository = FilmRepository(filmAPI)
    }

    val film: MutableLiveData<List<Film>> = filmRepository.film

    fun getFilm() {
        filmRepository.getFilm()
    }

    fun saveFilm(film: Film) {
        filmRepository.saveFilm(film)
    }
}