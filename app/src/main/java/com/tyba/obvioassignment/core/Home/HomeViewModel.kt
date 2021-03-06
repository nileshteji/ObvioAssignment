package com.tyba.obvioassignment.core.Home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.tyba.obvioassignment.data.JsonData
import com.tyba.obvioassignment.datasource.JsonDataSource
import kotlinx.coroutines.Dispatchers
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.Comparator


class HomeViewModel(application: Application) : AndroidViewModel(application) {

    var _application: Application = application
    var JsonList: MutableLiveData<List<JsonData>> = MutableLiveData()
    var jsonDataSource: JsonDataSource

    init {
        jsonDataSource = JsonDataSource(_application)
    }

    fun getJsonList(){

        var list:MutableList<JsonData> = jsonDataSource.convertJsonToGson()
        JsonList.value = list

    }







}