package com.training.vollwyweather

import android.content.Context
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class VolleyHandler(private val context: Context) {


    companion object {

        const val BASE_URL_WEATHER = "https://api.openweathermap.org/data/2.5/weather"


        const val API_KEY_WEATHER = "af3b39574d32647b1be6de5e7ac3dd5d"
    }
}