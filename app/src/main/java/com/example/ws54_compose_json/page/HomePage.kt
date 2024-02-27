package com.example.ws54_compose_json.page

import Averta
import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ws54_compose_json.R
import com.example.ws54_compose_json.constant.HomePageStaticData
import com.example.ws54_compose_json.constant.HomePageStaticData.getCurrentWeatherData
import com.example.ws54_compose_json.service.WeatherModal
import com.example.ws54_compose_json.widget.HomeAppBar
import com.example.ws54_compose_json.widget.NavDrawerContent
import labelSmall
import widgetLabelSmall
import java.time.LocalTime

object HomePage{
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun build(navController: NavController) {
        val lazyListState = rememberLazyListState()
        val scope = rememberCoroutineScope()
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet(modifier = Modifier.width(300.dp)) {
                    NavDrawerContent.build(
                        navController = navController,
                        scope = scope,
                        drawerState = drawerState
                    )
                }
            }) {
            Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
                HomeAppBar.build(
                    region = stringResource(id = R.string.current_location),
                    scope = scope,
                    drawerState = drawerState
                )
            }) {
                val currentWeatherData = getCurrentWeatherData()
                val forecastWeatherDataList = HomePageStaticData.getForecastWeatherData()
                val hourlyWeatherDataList=  HomePageStaticData.getHourlyWeatherData()

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp, top = 56.dp, 10.dp, 10.dp),
                    state = lazyListState
                ) {
                    item {
                        currentTempAndCondition(currentWeatherData)
                        MaxAndMinTemp(dataList = forecastWeatherDataList)
                        Spacer(modifier = Modifier.height(20.dp))
                        HourlyWeather(dataList = hourlyWeatherDataList)
                        Spacer(modifier = Modifier.height(20.dp))
                        WeatherInTenDays(dataList = forecastWeatherDataList)
                        Spacer(modifier = Modifier.height(20.dp))
                        PM25AndUv(data = currentWeatherData)
                    }
                }
            }
        }
    }
}

@Composable
fun currentTempAndCondition(data: WeatherModal.Current){
    Row(horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Column {
            Text(text = "${data.temp_c}°",
                fontSize = 80.sp,
                fontFamily = FontFamily.SansSerif,
                letterSpacing = -8.sp,
                fontWeight = FontWeight.Light,
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(text = "${data.description}",
                    modifier = Modifier.padding(start = 5.dp),
                    style = TextStyle(
                        fontFamily = Averta,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                    )
                )
            }
        }

        Image(
            painter = data.icon,
            contentDescription = null,
            modifier = Modifier
                .size(150.dp)
        )
    }
}

@Composable
fun MaxAndMinTemp(dataList: List<WeatherModal.ForecastDay>){
    Text(text = "${dataList[0].maxtemp_c}° / " +
            "${dataList[0].mintemp_c}°  ${stringResource(id = R.string.feels_like)} " +
            "${dataList[0].feelslike_c}°",
        style = labelSmall,
        modifier = Modifier
            .padding(start = 5.dp)
            .padding(start = 20.dp)
    )
}

@Composable
fun HourlyWeather(dataList: List<WeatherModal.Hourly>){
    val lazyListState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    var hourTime = LocalTime.now().hour
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .height(185.dp)
            .clip(RoundedCornerShape(size = 15.dp))
            .background(color = Color.Gray.copy(alpha = 0.5f))
            .padding(5.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
            ,horizontalArrangement = Arrangement.Center) {
            Text(text = stringResource(R.string.hourly_weather), fontFamily = Averta, color = Color.White, fontSize = 15.sp, textAlign = TextAlign.Center)
        }
        Divider(color = Color.White, modifier = Modifier
            .fillMaxWidth(0.92f)
            .padding(5.dp))
        LazyRow(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth(),
            state = lazyListState,
            ) {
            items(dataList.size)
            {
                _buildPerHourData(data = dataList[it])
            }
        }

        LaunchedEffect(coroutineScope){
            lazyListState.scrollToItem(hourTime)
        }
    }
}

@Composable
fun _buildPerHourData(data:WeatherModal.Hourly){
    Column(verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(5.dp)
    ) {
        Text(text = data.time, fontSize = 15.sp, color = Color.White)
        Image(painter = data.icon, contentDescription = null, modifier = Modifier.size(57.dp))
        Text(text = "${data.temp_c}°", fontFamily = Averta, color = Color.White, fontSize = 15.sp)
        Text(text = "${data.chance_of_rain}%", fontFamily = Averta, color = Color.White, fontSize = 15.sp)
    }
}
//10天內天氣狀態區域
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WeatherInTenDays(dataList: List<WeatherModal.ForecastDay>){
    Column(modifier = Modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(15.dp))
        .background(color = Color.Gray.copy(alpha = 0.5f))
        .padding(10.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Row(
            Modifier
                .fillMaxWidth()
            ,horizontalArrangement = Arrangement.Center) {
            Text(text = stringResource(R.string.weather_in_ten_days), fontFamily = Averta, color = Color.White, fontSize = 15.sp, textAlign = TextAlign.Center)
        }
        Divider(color = Color.White, modifier = Modifier
            .fillMaxWidth(0.92f)
            .padding(5.dp))
        dataList.forEach(){
            _buildTempInTenDaysData(data = it)
        }
    }
}

//10天內天氣狀態
@Composable
fun _buildTempInTenDaysData(data: WeatherModal.ForecastDay){
    Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth(),) {
        Row(Modifier.width(80.dp)) {
            Text(
                text = data.date,
                style = widgetLabelSmall
            )
        }
        Row(
            Modifier.width(60.dp)
        ){
            Text(
                text = "${data.daily_chance_of_rain}%",
                style = widgetLabelSmall
            )
        }

        Image(painter = data.icon, contentDescription = null, modifier = Modifier.size(50.dp), contentScale = ContentScale.Crop)
        Row(Modifier.width(60.dp)){
            Text(text = "${data.maxtemp_c}°", style = widgetLabelSmall)
        }
        Row(Modifier.width(60.dp)){
            Text(text = "${data.mintemp_c}°", style = widgetLabelSmall)
        }

    }
}

@Composable
fun PM25AndUv(data: WeatherModal.Current){
    Row(Modifier.fillMaxWidth() ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .clip(RoundedCornerShape(15.dp))
                .background(color = Color.Gray.copy(alpha = 0.5f))
                .padding(10.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,)
        {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(5.dp),horizontalArrangement = Arrangement.Center) {
                Text(text = "PM2.5", fontFamily = Averta, color = Color.White, fontSize = 15.sp, textAlign = TextAlign.Center)
            }
            Divider(color = Color.White, modifier = Modifier.fillMaxWidth(0.92f))
            Text(data.pm25.toString(),fontFamily = Averta, color = Color.White, fontSize = 40.sp,)
        }
        Spacer(modifier = Modifier.width(20.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(15.dp))
                .background(color = Color.Gray.copy(alpha = 0.5f))
                .padding(10.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,)
        {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(5.dp),horizontalArrangement = Arrangement.Center) {
                Text(text = "UV", fontFamily = Averta, color = Color.White, fontSize = 15.sp, textAlign = TextAlign.Center)
            }
            Divider(color = Color.White, modifier = Modifier.fillMaxWidth(0.92f))
            Text(data.uv.toString(),fontFamily = Averta, color = Color.White, fontSize = 40.sp,)
        }
    }
}