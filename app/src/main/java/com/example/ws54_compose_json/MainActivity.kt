package com.example.ws54_compose_json

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ws54_compose_json.page.HomePage
import com.example.ws54_compose_json.page.RegionPage
import com.example.ws54_compose_json.service.PreferencesManager
import com.example.ws54_compose_json.ui.theme.WS54_Compose_JsonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WS54_Compose_JsonTheme {
                val navController = rememberNavController()
                val preferencesManager = remember { PreferencesManager(this) }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    NavHost(navController = navController, startDestination = "Home") {
                        composable("Home") {
                            HomePage.build(navController)
                        }
                        composable("Region") {
                            RegionPage.build(navController, preferencesManager)
                        }
                    }
                }
            }
        }
    }
}