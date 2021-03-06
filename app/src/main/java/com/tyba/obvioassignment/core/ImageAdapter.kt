package com.tyba.obvioassignment.core

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tyba.obvioassignment.R
import com.tyba.obvioassignment.data.JsonData
import kotlinx.android.synthetic.main.recycler_view.view.*

class ImageAdapter constructor(var listData: List<JsonData>) :

    RecyclerView.Adapter<ImageAdapter.Holder>() {

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(data: JsonData){
            Log.d("recy",data.url)
            Picasso.get().load(data.url).error(R.drawable.ic_launcher_background).into(itemView.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val rootView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view, parent, false)

        return Holder(rootView)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int = listData.size
}