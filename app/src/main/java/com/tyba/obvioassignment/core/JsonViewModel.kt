package com.tyba.obvioassignment.core

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.tyba.obvioassignment.data.JsonData


class JsonViewModel(application: Application) : AndroidViewModel(application) {

    var _application :Application = application

    fun loadJson() :String?{

        var json : String? = null;

        try{
            var inputStream = _application.assets.open("data.json")
            var size :Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer)

        }catch (ex: Exception){

        }
        return json;
    }



    fun convertJsonToGson(){

        var gsonConvertor : Gson = Gson()

        var jsonString = loadJson()
        val typeToken :TypeToken<List<JsonData>> = object : TypeToken<List<JsonData>>() {}

        var list:List<JsonData> = gsonConvertor.fromJson<List<JsonData>>(jsonString,typeToken.type)

        list.size;
    }






}