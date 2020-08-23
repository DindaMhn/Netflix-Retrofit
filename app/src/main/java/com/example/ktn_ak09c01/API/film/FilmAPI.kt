package com.example.ktn_ak09c01.API.film

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface FilmAPI{
    @GET("films")
    fun getFilm(): Call<List<Film>>
    @POST("film")
    fun createFilm(@Body film: Film):Call<Film>
}