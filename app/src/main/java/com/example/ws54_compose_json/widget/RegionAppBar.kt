package com.example.ws54_compose_json.widget

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.ws54_compose_json.R

object RegionAppBar{
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun build(navController: NavController){
        TopAppBar(title = { Text(text = stringResource(R.string.maps), fontWeight = FontWeight.Bold )}, navigationIcon = {
            IconButton(onClick = {
                navController.navigate("Home")
            }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null,modifier = Modifier.size(25.dp))
            }
        })
    }
}