package com.example.ws54_compose_json.service

import androidx.compose.ui.graphics.painter.Painter

class WeatherModal{

    data class Location(
        val nation:String,
        val city:String,
        val region:String
    )

    data class Current(
        val temp_c:Int,
        val temp_f: Double,
        val feelslike_c: Double,
        val feelslike_f: Double,
        val uv: Double,
        val humidity:Int,
        val pm25: Double,
        val description: String,
        val icon:Painter
    )

    data class Hourly(
        val time: String,
        val temp_c:Int,
        val temp_f: Double,
        val chance_of_rain: Int,
        val icon: Painter,
    )

    data class ForecastDay(
        val date: String,
        val maxtemp_c: Double,
        val maxtemp_f: Double,
        val mintemp_c: Double,
        val mintemp_f: Double,
        val feelslike_c: Double,
        val feelslike_f: Double,
        val daily_chance_of_rain: Int,
        val icon: Painter,
    )
}

//class WeatherModal{
//    data class WeatherResponse(
//        val location: _location,
//        val current: _currency,
//        val forecast: _forecast
//    )
//
//    // 天氣資料的當前地理位置
//    data class _location(
//        val nation:String,
//        val city:String,
//        val region:String
//    )
//
//    // 當前且現在的天氣資料
//    data class _currency(
//        val temp_c:Int,
//        val temp_f:Float,
//        val feelslike_c: Float,
//        val feelslike_f: Float,
//        val uv: Double,
//        val condition: _condition,
//        val humidity:Int,
//        val pm25: Double
//    )
//
//    // 10天內預測資料，包著_forecastDay
//    data class _forecast(
//        val forecastDay:_forecastDay
//    )
//
//    // 各別的 forecastDay 資料，有此天的預測日期與資料類別
//    data class  _forecastDay(
//        val date: String,
//        val data:_forecastDayData
//    )
//
//    // 預測的一天天氣資料類別
//    data class _forecastDayData(
//        val maxtemp_c: Double,
//        val maxtemp_f: Double,
//        val mintemp_c: Double,
//        val mintemp_f: Double,
//        val daily_chance_of_rain: String,
//        val condition: _condition,
//    )
//
//    // 裝著天氣圖標跟天氣敘述文字
//    data class _condition(
//        val text:String,
//        val icon:String,
//    )
//}