package com.training.vollwyweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.android.volley.Request
import com.google.gson.reflect.TypeToken
import com.training.vollwyweather.VolleyHandler.Companion.API_KEY_WEATHER
import com.training.vollwyweather.VolleyHandler.Companion.BASE_URL_WEATHER
import com.training.vollwyweather.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sendGetTypeRequest("42.00", "12.10")
    }

    private fun sendGetTypeRequest(latitude: String, longitude: String) {
        val requestQueue = Volley.newRequestQueue(this)

        val queryParam = "lat=$latitude&lon=$longitude&appid=$API_KEY_WEATHER"
        val requestUrl = "$BASE_URL_WEATHER?$queryParam"
        val stringRequest = StringRequest(
            com.android.volley.Request.Method.GET,
            requestUrl,
            {
                //Success block
                val token = object : TypeToken<WeatherResponse>() {}
                val response = Gson().fromJson(it, token)
                Log.i("tag", response.base)
            }, {
                // error block
                Log.i("tag", it.toString())
            }
        )
        requestQueue.add(stringRequest)
    }
}