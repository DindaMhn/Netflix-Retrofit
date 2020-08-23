package com.example.ktn_ak09c01.API.film

import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import retrofit2.*

class FilmRepository(val filmAPI: FilmAPI) {
    var film: MutableLiveData<List<Film>> = MutableLiveData<List<Film>>()
    fun getFilm() {
        filmAPI.getFilm().enqueue(object : Callback<List<Film>> {
            override fun onFailure(call: Call<List<Film>>, t: Throwable) {
                println(t.localizedMessage)
            }

            override fun onResponse(call: Call<List<Film>>, response: Response<List<Film>>) {
                val gson = Gson().toJson(response.body())
                val res: List<Film> = Gson().fromJson(gson, Array<Film>::class.java).toList()
                film.value = res
            }
        })
    }

    fun saveFilm(film: Film) {
        filmAPI.createFilm(film).enqueue(object : Callback<Film> {
            override fun onFailure(call: Call<Film>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<Film>, response: Response<Film>) {
                if (response.code() == 200) {
                    println("SUCCESS")
                }
            }
        })
    }
}