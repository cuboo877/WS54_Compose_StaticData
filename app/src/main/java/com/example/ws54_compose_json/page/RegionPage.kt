package com.example.ws54_compose_json.page

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ws54_compose_json.R
import com.example.ws54_compose_json.constant.RegionPageStaticData
import com.example.ws54_compose_json.service.PreferencesManager
import com.example.ws54_compose_json.widget.RegionAppBar
import labelSmall

object RegionPage{
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun build(navController: NavController, preferencesManager: PreferencesManager){
        val openDialog = remember {
            mutableStateOf(false
            )
        }
        val citySet = setOf("Ayo","Taipei","TestCity","Yee")
        // 單純for多國語系用(???
        val translatedCityMap =  mapOf(
            "Ayo" to stringResource(id = R.string.ayo),
            "Taipei" to stringResource(id = R.string.taipei),
            "TestCity" to stringResource(id = R.string.testcity),
            "Yee" to stringResource(id = R.string.yee))

        val selectedCitySet:Set<String> = preferencesManager.getCitySet()
        val selectedCityMutableList = remember {
            mutableStateOf(selectedCitySet.toList())
        }
        val unselectedCityMutableList = remember {
            mutableStateOf(citySet.minus(selectedCitySet).toList())
        }
        Scaffold(
            topBar = { RegionAppBar.build(navController) },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        openDialog.value = true
                    },
                ) {
                    Icon(
                        Icons.Default.Add, contentDescription = null
                    )

                    if (openDialog.value){
                        AlertDialog(
                            modifier = Modifier
                                .height(400.dp)
                                .padding(0.dp),
                            onDismissRequest = { openDialog.value = false },
                            confirmButton = {
                            },
                            title = { Row(verticalAlignment = Alignment.CenterVertically,modifier = Modifier.fillMaxWidth()) {
                                Text(text = stringResource(R.string.add_a_region))
                            }},
                            text = {
                                LazyColumn(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                                    itemsIndexed(items = unselectedCityMutableList.value){
                                            index,city -> translatedCityMap[city]?.let {
                                        Text(
                                            text = it,
                                            fontSize = 20.sp,
                                            modifier = Modifier.clickable
                                            {
                                                openDialog.value = false
                                                preferencesManager.addData(city)
                                                selectedCityMutableList.value = preferencesManager.getCitySet().toList()
                                                unselectedCityMutableList.value = unselectedCityMutableList.value.minus(city).toList()
                                            }
                                        )
                                    }
                                        if(index != unselectedCityMutableList.value.size-1){
                                            Divider(modifier = Modifier
                                                .fillMaxWidth(0.9f)
                                                .padding(5.dp))
                                        }else{
                                            //nothing
                                        }
                                    }
                                }
                            })
                    }
                }
            }
        ) {
            val lazyListState = rememberLazyListState()
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 70.dp),
                state = lazyListState,
                contentPadding = PaddingValues(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                items(selectedCityMutableList.value.sorted()) {
                    _buildRegionWeatherRow(city = it, preferencesManager, selectedCityMutableList, unselectedCityMutableList)
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
    }

}

@Composable
fun _buildRegionWeatherRow(city: String, preferencesManager: PreferencesManager, selectedCityList: MutableState<List<String>>, unselectedCityList:  MutableState<List<String>>){
    val data: RegionPageStaticData._cityWeatherData? = RegionPageStaticData().getRegionWeatherData(
        city = city
    )

    Row(modifier = Modifier
        .fillMaxWidth(0.9f)
        .border(2.dp, Color.Black, RoundedCornerShape(15.dp))
        .clip(RoundedCornerShape(15.dp))
        .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
        ) {
        if (data != null) {
            Text(text = "${data.cityName}",modifier = Modifier.width(90.dp), style = labelSmall)
            Text(text = "${data.maxTemp_c}°",modifier = Modifier.width(35.dp), style = labelSmall)
            Text(text = "${data.minTemp_c}°",modifier = Modifier.width(35.dp), style = labelSmall)
            Image(painter = painterResource(id = data.iconRes), contentDescription = null,Modifier.size(40.dp))
            Text(text = "${data.chance_of_rain}%", style = labelSmall)
        }
        IconButton(onClick = {
            preferencesManager.removeData(city)
            selectedCityList.value = preferencesManager.getCitySet().toList()
            unselectedCityList.value = unselectedCityList.value.plus(city).toList()
        }) {
            Icon(imageVector = Icons.Default.Clear, contentDescription = null)
        }
    }
}
