package com.example.ktn_ak09c01.recycleadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.ktn_ak09c01.API.film.Film
import com.example.ktn_ak09c01.R
import com.squareup.picasso.Picasso

class FilmRecycleAdapter(
    private val filmList: List<Film>,
    private val getActivity: FragmentActivity?
) : RecyclerView.Adapter<FilmViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.film_item_layout, parent, false)
        return FilmViewHolder(view)
    }

    override fun getItemCount(): Int {
        return filmList.size
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        Picasso.with(getActivity)
            .load(filmList[position].image)
            .into(holder.imageViewItem)
        val bundle = bundleOf(
            Pair("image", filmList[position].image),
            Pair("synopsis", filmList[position].synopsis),
            Pair("duration", filmList[position].duration)
        )
        holder.imageViewItem.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_homeFragment_to_detailFragment, bundle)
        }
    }
}

class FilmViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val imageViewItem = v.findViewById<ImageView>(R.id.filmItemView)
}