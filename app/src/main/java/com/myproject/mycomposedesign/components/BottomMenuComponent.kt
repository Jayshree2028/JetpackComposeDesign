package com.myproject.mycomposedesign.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.myproject.mycomposedesign.R

@Composable
fun BottomMenuComponent() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val path = Path().apply {
                moveTo(0f, size.height) // Start at the bottom-left corner
                arcTo(
                    rect = androidx.compose.ui.geometry.Rect(
                        1f ,
                        size.height / 3,
                        size.width / 7,
                        size.height
                    ),
                    startAngleDegrees = 180f,
                    sweepAngleDegrees = 90f,
                    forceMoveTo = false,

                    )
                lineTo(size.width * 0.7f, size.height / 7)
                lineTo(size.width-100, 0f)
                lineTo(size.width, size.height)
                close()
            }
            clipPath(path) {
                drawPath(
                    path = path,
                    color = Color(0xFF3F51B5)
                )
            }
        }
        Row {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .width(350.dp)
                    .padding(top = 16.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.menu),
                    contentDescription = "Menu",
                    tint = Color.White,
                    modifier = Modifier
                        .size(40.dp)
                        .padding(top = 20.dp)
                )
                Icon(
                    painter = painterResource(R.drawable.game),
                    contentDescription = "Game",
                    tint = Color.White,
                    modifier = Modifier
                        .size(35.dp)
                        .padding(top = 20.dp)
                )
                Icon(
                    painter = painterResource(R.drawable.favorite),
                    contentDescription = "Favorite",
                    tint = Color.White,
                    modifier = Modifier
                        .size(40.dp)
                        .padding(top = 20.dp)
                )
                Icon(
                    painter = painterResource(R.drawable.message),
                    contentDescription = "Message",
                    tint = Color.White,
                    modifier = Modifier
                        .size(40.dp)
                        .padding(top = 20.dp)
                )


            }
        }
        Column (horizontalAlignment = Alignment.End)
        { Spacer(modifier = Modifier.width(400.dp))
            Box(
                modifier = Modifier
                    .size(70.dp)
                    .background(Color.White, shape = CircleShape)
                    .padding(2.dp)
            ){
                FloatingActionButton(
                    onClick = { /* TODO: Add your onClick action */ },
                    containerColor = Color(0xFF3F51B5),
                    shape = CircleShape,
                    modifier = Modifier
                        .size(50.dp)
                        .align(Alignment.Center)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.add),
                        contentDescription = "Add",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }


      /*  Box(
            modifier = Modifier
                .size(60.dp)
                .background(Color.White, shape = CircleShape)
                .offset(x = 330.dp, y = (1).dp)
        ) {
            FloatingActionButton(
                onClick = { },
                containerColor = Color(0xFF3F51B5),
                shape = CircleShape,
                modifier = Modifier
                    .size(56.dp)
                    .offset(x = 330.dp, y = (1).dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.add),
                    contentDescription = "Add",
                    tint = Color.White,
                    modifier = Modifier.size(30.dp)

                )
            }*/

//        }

    }
}

@Preview
@Composable
fun BottomMenuComponentPrev() {
    BottomMenuComponent()
}
