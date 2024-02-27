package com.example.ws54_compose_json.constant

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.ws54_compose_json.R

class RegionPageStaticData {
    @Composable
    fun getRegionWeatherData(city:String): _cityWeatherData? {
        val cityWeatherDataMap = mapOf(
            "Taipei" to _cityWeatherData(
                stringResource(R.string.taipei),
                20,
                10,
                200.0,
                100.0,
                45,
                R.drawable.morning_sun_sunrise_icon
            ),

            "Yee" to _cityWeatherData(
                stringResource(R.string.yee),
                20,
                10,
                200.0,
                100.0,
                45,
                R.drawable.morning_sun_sunrise_icon
            ),

            "Ayo" to _cityWeatherData(
                stringResource(R.string.ayo),
                20,
                10,
                200.0,
                100.0,
                45,
                R.drawable.morning_sun_sunrise_icon
            ),

            "TestCity" to _cityWeatherData(
                stringResource(R.string.testcity),
                20,
                10,
                200.0,
                100.0,
                45,
                R.drawable.morning_sun_sunrise_icon
            ),
        )

        return cityWeatherDataMap[city]
    }

    data class _cityWeatherData(
        val cityName:String,
        val maxTemp_c : Int,
        val minTemp_c : Int,
        val maxTemp_f : Double,
        val minTemp_f : Double,
        val chance_of_rain : Int,
        val iconRes : Int
    )
}

