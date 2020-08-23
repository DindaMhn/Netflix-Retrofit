package com.example.ktn_ak09c01.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.ktn_ak09c01.API.film.Film
import com.example.ktn_ak09c01.API.film.FilmViewModel
import com.example.ktn_ak09c01.R
import kotlinx.android.synthetic.main.fragment_create_film.*

class CreateFilmFragment : Fragment(), View.OnClickListener {
    val filmViewModel by activityViewModels<FilmViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_film, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        submitButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            submitButton -> {
                val film = Film(
                    title = titleInput.text.toString(),
                    duration = durationInput.text.toString(),
                    image = imageInput.text.toString(),
                    synopsis = synopsisInput.text.toString()
                )
                filmViewModel.saveFilm(film)
            }
        }
    }
}