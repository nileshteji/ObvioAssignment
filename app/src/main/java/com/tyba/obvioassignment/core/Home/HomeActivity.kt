package com.tyba.obvioassignment.core.Home

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.tyba.obvioassignment.R
import com.tyba.obvioassignment.core.adapters.ImageAdapter
import com.tyba.obvioassignment.data.JsonData
import com.tyba.obvioassignment.utils.rvClicListener
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity() , rvClicListener {

    val homeViewModel : HomeViewModel by viewModels()
    lateinit var rv : ImageAdapter
    lateinit var jsonList: List<JsonData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        homeViewModel.convertJsonToGson()
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = linearLayoutManager

        homeViewModel.JsonList.observe(this){ listJson ->
            jsonList = listJson
            rv = ImageAdapter(listJson)
            recyclerView.adapter = rv
        }
    }

    override fun click(a: Int) {
        jsonList[a]
    }
}