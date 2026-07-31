package com.manga.ui.components.navigation


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.manga.models.Screens


import androidx.compose.material3.Icon
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.currentBackStackEntryAsState

import org.jetbrains.compose.resources.painterResource

import javayomiv2.shared.generated.resources.Res
import javayomiv2.shared.generated.resources.icons8_library_50
import javayomiv2.shared.generated.resources.icons8_download_26
import javayomiv2.shared.generated.resources.icons8_search_64
import javayomiv2.shared.generated.resources.icons8_setting_50
import javayomiv2.shared.generated.resources.icons8_extensions_folder_24



// Refactor
@Composable
fun Sidebar(navController: NavController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val isSelected = currentRoute == Screens.Library::class.qualifiedName

    Surface {
        Column(Modifier
            .width(180.dp)
            .fillMaxHeight()
            .drawBehind{
                val strokeWidth = 1.dp.toPx()
                drawLine(
                    color = Color.LightGray,
                    start = Offset(size.width - strokeWidth / 2, 0f),
                    end = Offset(size.width - strokeWidth / 2, size.height),
                    strokeWidth = 1.dp.toPx() )

            }
        ) {
            Row(modifier = Modifier
                .padding(start = 15.dp, end = 15.dp, top=10.dp )
                .height(50.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(5.dp))
                .background(if (isSelected) Color(0xFFEDEBF5) else Color.Transparent)
                .clickable(onClick = { navController.navigate(Screens.Library) }),

                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    painter = painterResource(Res.drawable.icons8_library_50),
                    contentDescription = "Library",
                    modifier = Modifier
                        .size(30.dp)
                        .padding(start = 10.dp)
                )
                Text(text = "Library",
                    modifier = Modifier.
                    padding(start=10.dp),
                    style = MaterialTheme.typography.labelLarge)
            }
            Row(modifier = Modifier
                .padding(start = 15.dp, end = 15.dp, top=10.dp )
                .height(50.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(5.dp))
                .clickable(onClick = {navController.navigate(Screens.Library)}),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    painter = painterResource(Res.drawable.icons8_extensions_folder_24),
                    contentDescription = "Library",
                    modifier = Modifier
                        .size(30.dp)
                        .padding(start = 10.dp)
                )
                Text(text = "Extensions",
                    modifier = Modifier.
                    padding(start=10.dp),
                    style = MaterialTheme.typography.labelLarge)
            }

            Row(modifier = Modifier
                .padding(start = 15.dp, end = 15.dp, top=10.dp )
                .height(50.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(5.dp))
                .clickable(onClick = {navController.navigate(Screens.Library)}),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    painter = painterResource(Res.drawable.icons8_search_64),
                    contentDescription = "Library",
                    modifier = Modifier
                        .size(30.dp)
                        .padding(start = 10.dp)
                )
                Text(text = "Browse",
                    modifier = Modifier.
                    padding(start=10.dp),
                    style = MaterialTheme.typography.labelLarge)
            }

            Row(modifier = Modifier
                .padding(start = 15.dp, end = 15.dp, top=10.dp )
                .height(50.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(5.dp))
                .clickable(onClick = {navController.navigate(Screens.Library)}),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    painter = painterResource(Res.drawable.icons8_download_26),
                    contentDescription = "Library",
                    modifier = Modifier
                        .size(30.dp)
                        .padding(start = 10.dp)
                )

                Text(text = "Downloads",
                    modifier = Modifier.
                    padding(start=10.dp),
                    style = MaterialTheme.typography.labelLarge)
            }
            Spacer(modifier = Modifier.weight(1f))
            Row(modifier = Modifier
                .padding(start = 15.dp, end = 15.dp, top=10.dp )
                .height(50.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(5.dp))
                .clickable(onClick = {navController.navigate(Screens.Library)}),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    painter = painterResource(Res.drawable.icons8_setting_50),
                    contentDescription = "Library",
                    modifier = Modifier
                        .size(25.dp)
                        .padding(start = 10.dp)
                )

                Text(text = "Settings",
                    modifier = Modifier.
                    padding(start=10.dp),
                    style = MaterialTheme.typography.labelLarge)
            }
        }
    }





}
