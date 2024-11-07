package com.myproject.mycomposedesign.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.IconButton

import androidx.compose.material.Text
import androidx.compose.material3.Button

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myproject.mycomposedesign.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun DetailsScreen(drawerState: androidx.compose.material3.DrawerState, scope: CoroutineScope) {
    Card(
//        shape = RoundedCornerShape(2.dp), elevation = 8.dp, modifier = Modifier.fillMaxWidth()

    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Box {
                Image(
                    painter = painterResource(id = R.drawable.image_main),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp),
                    contentScale = ContentScale.Crop
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(
                        onClick = {
                            scope.launch {
                                if (drawerState.isClosed) drawerState.open() else drawerState.close()
                            }
                        }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.image_back),
                            contentDescription = "Menu",
                            modifier = Modifier.size(40.dp)
                        )
                    }

                    IconButton(
                        onClick = { /* Handle menu action */ }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.image_drawer_open),
                            contentDescription = "Menu",
                            modifier = Modifier.size(40.dp)
                        )
                    }
                }
            }


            Card(
                shape = RoundedCornerShape(24.dp),
                elevation = 8.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp)
                    .offset(y = -(30).dp)
            ) {
                Column {
                    Text(

                        "Horizon",
                        textAlign = TextAlign.Center,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                    )
                    Text(

                        "Forbidden West",
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp)
                    )
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 30.dp),
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Normal,
                        text = "Join Aloy as she braves the Forbidden \nWest – a majestic but dangerous frontier \nthat conceals mysterious new threats."
                    )
                    Button(
                        onClick = {

                        },
                        modifier = Modifier
                            .padding(top = 30.dp)
                            .align(Alignment.CenterHorizontally),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF2690DE)
                        )
                    ) {
                        Text(text = "Play Now", color = Color.White)
                    }
                    Card(
                        shape = RoundedCornerShape(24.dp),
                        elevation = 8.dp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                            .padding(5.dp)
                            .padding(top = 16.dp),
                        backgroundColor = Color(0xFF9FD1F6)

                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.image_ani),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxHeight()

                                .padding(end = 20.dp),

                            contentScale = ContentScale.FillHeight

                        )
                        Column {
                            Text(

                                "Fortnite \nTournament",

                                fontSize = 25.sp,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold,
//                                modifier = Modifier
//                                    .padding(start = 220.dp)

                                modifier = Modifier
                                    .align(Alignment.End)
                                    .padding(end = 25.dp, top = 40.dp)

                            )
                            Button(
                                onClick = {

                                },
                                modifier = Modifier
                                    .align(Alignment.End)
                                    .padding(end = 35.dp, top = 5.dp),

                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF2690DE)
                                )
                            ) {
                                Text(text = "Play Now", color = Color.White)
                            }
                        }


                    }

                }

            }
        }
    }

}


/*@Composable
fun DetailsScreen() {

    Column {
        Image(
            painter = painterResource(R.drawable.image_main),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .size(310.dp),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .offset(y = (-20).dp),
            contentAlignment = Alignment.TopCenter
        ){
            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF4FBFD)),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {

            }
        }


    }


}*/

@Preview(showSystemUi = true)
@Composable
fun PreviewDetailsScreen() {
//    DetailsScreen()
}