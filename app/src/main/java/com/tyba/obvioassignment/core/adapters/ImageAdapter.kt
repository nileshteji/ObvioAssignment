package com.tyba.obvioassignment.core.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tyba.obvioassignment.R
import com.tyba.obvioassignment.core.Home.HomeActivity
import com.tyba.obvioassignment.data.JsonData
import com.tyba.obvioassignment.utils.rvClicListener
import kotlinx.android.synthetic.main.recycler_view.view.*

class ImageAdapter constructor(var activity: HomeActivity, var listData: List<JsonData>) :

    RecyclerView.Adapter<ImageAdapter.Holder>() {

    class Holder(val _activity: HomeActivity,val itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(data: JsonData) {

            itemView.text_title.text = data.title
            itemView.date.text = data.date;
            Picasso.get().load(data.url).error(R.drawable.ic_launcher_background)
                .into(itemView.image)

            itemView.setOnClickListener(){
               _activity.click(adapterPosition)
            }

        }





    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val rootView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view, parent, false)

        return Holder(activity,rootView)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int = listData.size
}