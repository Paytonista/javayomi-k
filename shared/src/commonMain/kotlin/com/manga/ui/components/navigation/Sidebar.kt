package com.manga.ui.components.navigation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Web
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.manga.models.Screens
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width

import androidx.compose.material3.Surface
import androidx.compose.material3.Text


import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush

import androidx.compose.ui.unit.dp

import androidx.compose.ui.graphics.Color

@Composable
fun Sidebar(navController: NavController) {

    Surface(
       ) {
        Column(Modifier
            .width(140.dp)
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
                .padding(start=2.dp, end=2.dp)
                .height(30.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(2.dp))
                .clickable(onClick = {navController.navigate(Screens.Library)})
                ,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(text = "Library",
                    modifier = Modifier.
                    padding(5.dp),
                    style = MaterialTheme.typography.labelLarge)
            }
            Row(modifier = Modifier

                .height(30.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(2.dp))
                .clickable(onClick = {navController.navigate(Screens.Library)}),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(text = "Extensions",
                    modifier = Modifier.
                    padding(5.dp),
                    style = MaterialTheme.typography.labelLarge)
            }
            Row(modifier = Modifier

                .height(30.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(2.dp))
                .clickable(onClick = {navController.navigate(Screens.Library)}),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(text = "Downloads",
                    modifier = Modifier.
                    padding(5.dp),
                    style = MaterialTheme.typography.labelLarge)
            }
            Row(modifier = Modifier

                .height(30.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(2.dp))
                .clickable(onClick = {navController.navigate(Screens.Library)}),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(text = "Settings",
                    modifier = Modifier.
                    padding(5.dp),
                    style = MaterialTheme.typography.labelLarge)
            }
        }
    }





}
