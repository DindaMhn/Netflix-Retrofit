package com.example.ktn_ak09c01.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.ktn_ak09c01.API.film.FilmViewModel
import com.example.ktn_ak09c01.R
import com.example.ktn_ak09c01.recycleadapter.FilmRecycleAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    val filmViewModel by activityViewModels<FilmViewModel>()
    lateinit var adapter: FilmRecycleAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        filmRecycleView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        filmViewModel.film.observe(viewLifecycleOwner, Observer {
            adapter = FilmRecycleAdapter(it, activity)
            filmRecycleView.adapter= adapter
        })
        filmViewModel.getFilm()
    }
}