package com.octo.skool.front.helloskool.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.octo.skool.front.helloskool.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_hero.view.*

class HeroesAdapter : RecyclerView.Adapter<HeroViewHolder>() {

    var list: List<Hero> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        return LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_hero, parent, false)
            .let(::HeroViewHolder)
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        holder.itemView.heroName.text = list[position].name
        Picasso.get().load(list[position].imageUrl).into(holder.itemView.heroImage)
    }

}

class HeroViewHolder(view: View) : RecyclerView.ViewHolder(view)