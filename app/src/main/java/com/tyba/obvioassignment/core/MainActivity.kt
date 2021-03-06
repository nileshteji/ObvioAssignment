package com.tyba.obvioassignment.core

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.tyba.obvioassignment.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val jsonViewModel : JsonViewModel by viewModels()
    lateinit var rv : ImageAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        jsonViewModel.convertJsonToGson()
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = linearLayoutManager

        jsonViewModel.JsonList.observe(this){ listJson ->
            rv = ImageAdapter(listJson)
            recyclerView.adapter = rv
        }
    }
}