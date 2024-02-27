package com.example.ws54_compose_json.service

import android.content.Context
import android.content.SharedPreferences

class PreferencesManager(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

    fun addData(value: String) {
        val citySet = getCitySet().plus(value)
        val editor = sharedPreferences.edit()
        editor.putStringSet("CityList", citySet)
        editor.apply()
    }
    fun removeData(value: String) {
        val citySet = getCitySet().minus(value)
        val editor = sharedPreferences.edit()
        editor.putStringSet("CityList", citySet)
        editor.apply()
    }
    fun getCitySet(): Set<String> {
        val defaultValue:Set<String> = setOf("Taichung")
        return sharedPreferences.getStringSet("CityList", defaultValue) ?: defaultValue
    }
}