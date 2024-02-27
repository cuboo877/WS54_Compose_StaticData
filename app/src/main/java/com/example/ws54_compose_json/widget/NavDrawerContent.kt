package com.example.ws54_compose_json.widget
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ws54_compose_json.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

object NavDrawerContent{
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun build(navController: NavController, scope: CoroutineScope, drawerState: DrawerState){
        Column {
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = {scope.launch { drawerState.close() }}) {
                    Icon(imageVector = Icons.Default.Close, contentDescription = null, modifier = Modifier.size(30.dp))
                }
                Spacer(modifier = Modifier.weight(1f))
                Image(painter = painterResource(id = R.drawable.icon), contentDescription = null,modifier = Modifier
                    .size(40.dp)
                    .padding(5.dp))
            }
            Spacer(modifier = Modifier.height(20.dp))
            DrawerItem(
                title = stringResource(R.string.NavDrawerContent_home), navTarget = "Home",
                navController = navController, backgroundRes = R.drawable.icon, iconRes = Icons.Default.Home)
            Spacer(modifier = Modifier.height(20.dp))
            DrawerItem(
                title = stringResource(R.string.NavDrawerContent_region), navTarget = "Region",
                navController = navController, backgroundRes = R.drawable.icon, iconRes = Icons.Default.LocationOn)
        }
    }

    @Composable
    fun DrawerItem(title:String, navTarget: String, navController: NavController, backgroundRes: Int, iconRes: ImageVector){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(start = 10.dp, end = 10.dp)
                .clip(
                    RoundedCornerShape(16.dp)
                )
                .paint(
                    painter = painterResource(id = backgroundRes),
                    contentScale = ContentScale.Crop
                )
                .clickable { navController.navigate(navTarget) }
            ,verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                modifier = Modifier.padding(start = 10.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = {}) {
                Icon(imageVector = iconRes, contentDescription = null, tint = Color.White)
            }
        }
    }
}