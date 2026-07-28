package com.manga

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.window.WindowDraggableArea
import androidx.compose.material.icons.Icons

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowScope
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState


import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material.icons.filled.Close
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import org.jetbrains.skia.Surface


fun main() = application {
    val windowState = rememberWindowState(width = 800.dp, height = 400.dp)

    Window(
        onCloseRequest = ::exitApplication,
        title = "Javayomi",
        resizable = false,
        undecorated = true,
        transparent = true,
        state = WindowState()
    ) {

        Surface (modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(12.dp)),
            color = MaterialTheme.colorScheme.background) {
            Column(Modifier.fillMaxSize()){
                CustomTitleBar( windowState = windowState, onCloseRequest = ::exitApplication)
                App()
            }
        }


    }
}


@Composable
private fun WindowScope.CustomTitleBar(
    windowState: WindowState,
    onCloseRequest: () -> Unit,
) {
    WindowDraggableArea {
        Row (modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
            .drawBehind {
                val strokeWidth = 1.dp.toPx()
                drawLine(
                    color = Color.LightGray,
                    start = Offset(0f, size.height - strokeWidth / 2),
                    end = Offset(size.width, size.height - strokeWidth / 2),
                    strokeWidth = 1.dp.toPx() )
            },
            verticalAlignment = Alignment.CenterVertically,
        ){

            Text(text = "Javayomi",
                letterSpacing = 2.sp,
                fontSize = 12.sp,
                fontFamily = FontFamily.Monospace,)

            Spacer(Modifier.weight(1f))
            IconButton(onClick = onCloseRequest, shape = RectangleShape) {
                Icon(Icons.Filled.Close,
                    contentDescription = "Close",
                    modifier = Modifier.size(20.dp))
            }

        }

    }

}

