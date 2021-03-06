package com.tyba.obvioassignment.core.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import com.tyba.obvioassignment.R
import com.tyba.obvioassignment.data.JsonData
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    var jsonData: JsonData? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        jsonData = intent.getParcelableExtra<JsonData>("object")

        Picasso.get().load(jsonData?.url).into(detailImage)
        detailTitle.text = jsonData?.title
        detail.text = jsonData?.explanation
        copyright.text = jsonData?.copyright
        dateDetail.text = jsonData?.date

    }
}