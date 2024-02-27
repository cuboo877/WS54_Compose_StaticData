package com.example.ws54_compose_json.constant

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.ws54_compose_json.R
import com.example.ws54_compose_json.service.WeatherModal

object HomePageStaticData {
    @Composable
    fun getCurrentWeatherData(): WeatherModal.Current {
        val currentWeatherData = WeatherModal.Current(
            temp_c = 10,
            temp_f = 20.0,
            feelslike_c = 5.0,
            feelslike_f = 20.0,
            uv = 9.9,
            humidity = 30,
            pm25 = 60.7,
            description = stringResource(id = R.string.sunny),
            icon = painterResource(id = R.drawable.morning_sun_sunrise_icon)
        )
        return currentWeatherData
    }

    @Composable
    fun getForecastWeatherData(): List<WeatherModal.ForecastDay> {
        val forecastWeatherDataList = listOf(
            WeatherModal.ForecastDay(
                maxtemp_c = 10.0,
                date = "2/26",
                maxtemp_f = 200.0,
                mintemp_c = 5.0,
                mintemp_f = 5.0,
                daily_chance_of_rain = 80,
                feelslike_c = 5.0,
                feelslike_f = 30.0,
                icon = painterResource(
                    id = R.drawable.clouds_cloudy_rain_sunny_icon
                ),),
            WeatherModal.ForecastDay(
                maxtemp_c = 10.0,
                date = "2/27",
                maxtemp_f = 200.0,
                mintemp_c = 5.0,
                mintemp_f = 5.0,
                daily_chance_of_rain = 80,
                feelslike_c = 5.0,
                feelslike_f = 30.0,
                icon = painterResource(
                    id = R.drawable.clouds_cloudy_rain_sunny_icon
                ),),
            WeatherModal.ForecastDay(
                maxtemp_c = 10.0,
                date = "2/28",
                maxtemp_f = 200.0,
                mintemp_c = 5.0,
                mintemp_f = 5.0,
                daily_chance_of_rain = 80,
                feelslike_c = 5.0,
                feelslike_f = 30.0,
                icon = painterResource(
                    id = R.drawable.clouds_cloudy_rain_sunny_icon
                ),),
            WeatherModal.ForecastDay(
                maxtemp_c = 10.0,
                date = "2/29",
                maxtemp_f = 200.0,
                mintemp_c = 5.0,
                mintemp_f = 5.0,
                daily_chance_of_rain = 80,
                feelslike_c = 5.0,
                feelslike_f = 30.0,
                icon = painterResource(
                    id = R.drawable.clouds_cloudy_rain_sunny_icon
                ),),
            WeatherModal.ForecastDay(
                maxtemp_c = 10.0,
                date = "3/1",
                maxtemp_f = 200.0,
                mintemp_c = 5.0,
                mintemp_f = 5.0,
                daily_chance_of_rain = 80,
                feelslike_c = 5.0,
                feelslike_f = 30.0,
                icon = painterResource(
                    id = R.drawable.clouds_cloudy_rain_sunny_icon
                ),),
            WeatherModal.ForecastDay(
                maxtemp_c = 10.0,
                date = "3/2",
                maxtemp_f = 200.0,
                mintemp_c = 5.0,
                mintemp_f = 5.0,
                daily_chance_of_rain = 80,
                feelslike_c = 5.0,
                feelslike_f = 30.0,
                icon = painterResource(
                    id = R.drawable.clouds_cloudy_rain_sunny_icon
                ),),
            WeatherModal.ForecastDay(
                maxtemp_c = 10.0,
                date = "3/3",
                maxtemp_f = 200.0,
                mintemp_c = 5.0,
                mintemp_f = 5.0,
                daily_chance_of_rain = 80,
                feelslike_c = 5.0,
                feelslike_f = 30.0,
                icon = painterResource(
                    id = R.drawable.clouds_cloudy_rain_sunny_icon
                ),),
            WeatherModal.ForecastDay(
                maxtemp_c = 10.0,
                date = "3/4",
                maxtemp_f = 200.0,
                mintemp_c = 5.0,
                mintemp_f = 5.0,
                daily_chance_of_rain = 80,
                feelslike_c = 5.0,
                feelslike_f = 30.0,
                icon = painterResource(
                    id = R.drawable.clouds_cloudy_rain_sunny_icon
                ),),
            WeatherModal.ForecastDay(
                maxtemp_c = 10.0,
                date = "3/5",
                maxtemp_f = 200.0,
                mintemp_c = 5.0,
                mintemp_f = 5.0,
                daily_chance_of_rain = 80,
                feelslike_c = 5.0,
                feelslike_f = 30.0,
                icon = painterResource(
                    id = R.drawable.clouds_cloudy_rain_sunny_icon
                ),),
            WeatherModal.ForecastDay(
                maxtemp_c = 10.0,
                date = "3/5",
                maxtemp_f = 200.0,
                mintemp_c = 5.0,
                mintemp_f = 5.0,
                daily_chance_of_rain = 80,
                feelslike_c = 5.0,
                feelslike_f = 30.0,
                icon = painterResource(
                    id = R.drawable.clouds_cloudy_rain_sunny_icon
                ),),
            WeatherModal.ForecastDay(
                maxtemp_c = 10.0,
                date = "3/6",
                maxtemp_f = 200.0,
                mintemp_c = 5.0,
                mintemp_f = 5.0,
                daily_chance_of_rain = 80,
                feelslike_c = 5.0,
                feelslike_f = 30.0,
                icon = painterResource(
                    id = R.drawable.clouds_cloudy_rain_sunny_icon
                ),),
        )
        return forecastWeatherDataList
    }

    @Composable
    fun getHourlyWeatherData(): List<WeatherModal.Hourly> {
        val hourlyWeatherDataList = listOf(
            WeatherModal.Hourly(
                temp_c = 10,
                temp_f = 200.0,
                time = "00:00",
                chance_of_rain = 50,
                icon = painterResource(id = R.drawable.cloudy_storm_wind_icon)
            ),
            WeatherModal.Hourly(
                temp_c = 10,
                temp_f = 200.0,
                time = "01:00",
                chance_of_rain = 50,
                icon = painterResource(id = R.drawable.cloudy_storm_wind_icon)
            ),
            WeatherModal.Hourly(
                temp_c = 10,
                temp_f = 200.0,
                time = "02:00",
                chance_of_rain = 50,
                icon = painterResource(id = R.drawable.cloudy_storm_wind_icon)
            ),
            WeatherModal.Hourly(
                temp_c = 10,
                temp_f = 200.0,
                time = "03:00",
                chance_of_rain = 50,
                icon = painterResource(id = R.drawable.cloudy_storm_wind_icon)
            ),
            WeatherModal.Hourly(
                temp_c = 10,
                temp_f = 200.0,
                time = "04:00",
                chance_of_rain = 50,
                icon = painterResource(id = R.drawable.cloudy_storm_wind_icon)
            ),
            WeatherModal.Hourly(
                temp_c = 10,
                temp_f = 200.0,
                time = "05:00",
                chance_of_rain = 50,
                icon = painterResource(id = R.drawable.cloudy_storm_wind_icon)
            ),
            WeatherModal.Hourly(
                temp_c = 10,
                temp_f = 200.0,
                time = "06:00",
                chance_of_rain = 50,
                icon = painterResource(id = R.drawable.cloudy_storm_wind_icon)
            ),
            WeatherModal.Hourly(
                temp_c = 10,
                temp_f = 200.0,
                time = "07:00",
                chance_of_rain = 50,
                icon = painterResource(id = R.drawable.cloudy_storm_wind_icon)
            ),
            WeatherModal.Hourly(
                temp_c = 10,
                temp_f = 200.0,
                time = "08:00",
                chance_of_rain = 50,
                icon = painterResource(id = R.drawable.cloudy_storm_wind_icon)
            ),
            WeatherModal.Hourly(
                temp_c = 10,
                temp_f = 200.0,
                time = "09:00",
                chance_of_rain = 50,
                icon = painterResource(id = R.drawable.cloudy_storm_wind_icon)
            ),
            WeatherModal.Hourly(
                temp_c = 10,
                temp_f = 200.0,
                time = "10:00",
                chance_of_rain = 50,
                icon = painterResource(id = R.drawable.cloudy_storm_wind_icon)
            ),
            WeatherModal.Hourly(
                temp_c = 10,
                temp_f = 200.0,
                time = "11:00",
                chance_of_rain = 50,
                icon = painterResource(id = R.drawable.cloudy_storm_wind_icon)
            ),
            WeatherModal.Hourly(
                temp_c = 10,
                temp_f = 200.0,
                time = "11:00",
                chance_of_rain = 50,
                icon = painterResource(id = R.drawable.cloudy_storm_wind_icon)
            ),
            WeatherModal.Hourly(
                temp_c = 10,
                temp_f = 200.0,
                time = "12:00",
                chance_of_rain = 50,
                icon = painterResource(id = R.drawable.cloudy_storm_wind_icon)
            ),
            WeatherModal.Hourly(
                temp_c = 10,
                temp_f = 200.0,
                time = "13:00",
                chance_of_rain = 50,
                icon = painterResource(id = R.drawable.cloudy_storm_wind_icon)
            ),
            WeatherModal.Hourly(
                temp_c = 10,
                temp_f = 200.0,
                time = "14:00",
                chance_of_rain = 50,
                icon = painterResource(id = R.drawable.cloudy_storm_wind_icon)
            ),
            WeatherModal.Hourly(
                temp_c = 10,
                temp_f = 200.0,
                time = "15:00",
                chance_of_rain = 50,
                icon = painterResource(id = R.drawable.cloudy_storm_wind_icon)
            ),
            WeatherModal.Hourly(
                temp_c = 10,
                temp_f = 200.0,
                time = "16:00",
                chance_of_rain = 50,
                icon = painterResource(id = R.drawable.cloudy_storm_wind_icon)
            ),
            WeatherModal.Hourly(
                temp_c = 10,
                temp_f = 200.0,
                time = "17:00",
                chance_of_rain = 50,
                icon = painterResource(id = R.drawable.cloudy_storm_wind_icon)
            ),
            WeatherModal.Hourly(
                temp_c = 10,
                temp_f = 200.0,
                time = "18:00",
                chance_of_rain = 50,
                icon = painterResource(id = R.drawable.cloudy_storm_wind_icon)
            ),
            WeatherModal.Hourly(
                temp_c = 10,
                temp_f = 200.0,
                time = "19:00",
                chance_of_rain = 50,
                icon = painterResource(id = R.drawable.cloudy_storm_wind_icon)
            ),
            WeatherModal.Hourly(
                temp_c = 10,
                temp_f = 200.0,
                time = "20:00",
                chance_of_rain = 50,
                icon = painterResource(id = R.drawable.cloudy_storm_wind_icon)
            ),
            WeatherModal.Hourly(
                temp_c = 10,
                temp_f = 200.0,
                time = "21:00",
                chance_of_rain = 50,
                icon = painterResource(id = R.drawable.cloudy_storm_wind_icon)
            ),
            WeatherModal.Hourly(
                temp_c = 10,
                temp_f = 200.0,
                time = "22:00",
                chance_of_rain = 50,
                icon = painterResource(id = R.drawable.cloudy_storm_wind_icon)
            ),
            WeatherModal.Hourly(
                temp_c = 10,
                temp_f = 200.0,
                time = "23:00",
                chance_of_rain = 50,
                icon = painterResource(id = R.drawable.cloudy_storm_wind_icon)
            )
        )
        return hourlyWeatherDataList
    }
}