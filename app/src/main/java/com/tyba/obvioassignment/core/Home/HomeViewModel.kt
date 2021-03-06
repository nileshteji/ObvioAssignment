package com.tyba.obvioassignment.core.Home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.tyba.obvioassignment.data.JsonData
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.Comparator


class HomeViewModel(application: Application) : AndroidViewModel(application) {

    var _application: Application = application
    var JsonList: MutableLiveData<List<JsonData>> = MutableLiveData()
    fun loadJson(): String? {

        var json: String? = null;

        try {
            val inputStream = _application.assets.open("data.json")
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer)

        } catch (ex: Exception) {

        }
        return json;
    }


    fun convertJsonToGson() {

        val gsonConvertor: Gson = Gson()

        val jsonString = loadJson()

        val typeToken: TypeToken<MutableList<JsonData>> = object : TypeToken<MutableList<JsonData>>() {}

        val list : MutableList<JsonData> = gsonConvertor.fromJson(jsonString, typeToken.type)

        list.sortByDescending{it.date}

        JsonList.value =list
    }







}