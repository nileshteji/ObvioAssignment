package com.tyba.obvioassignment.core

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.tyba.obvioassignment.R

class MainActivity : AppCompatActivity() {

    val jsonViewModel : JsonViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        jsonViewModel.convertJsonToGson()


        jsonViewModel.JsonList.observe(this){ listJson ->

        }
    }



}