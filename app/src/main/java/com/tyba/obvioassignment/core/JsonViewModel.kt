package com.tyba.obvioassignment.core

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import java.lang.Exception

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

        }catch (ex :Exception){

        }
        return json;
    }



    fun convertJsonToGson(){

    }






}