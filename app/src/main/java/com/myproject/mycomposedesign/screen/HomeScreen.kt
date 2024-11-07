package com.myproject.mycomposedesign.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myproject.mycomposedesign.R
import com.myproject.mycomposedesign.components.BottomMenuComponent
import com.myproject.mycomposedesign.components.CardListComponent

@Composable
fun HomeScreen() {

    Column {
        Card(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp,

                ), colors = CardDefaults.cardColors(
                containerColor = Color(0xFF9FD1F6)
            ), modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(10.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.globe),
                    contentDescription = "Sample Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = " Great games to play \nand stay connected",
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(20.dp),
                    fontWeight = FontWeight.Bold,

                    )

            }

        }
        Text(
            text = "Popular Games",
            modifier = Modifier.padding(10.dp),
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        )
        Card(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp,

                ), colors = CardDefaults.cardColors(
                containerColor = Color(0xFFEFF2F3)
            ), modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(10.dp)
        ) {
            CardListComponent()
        }

    }


}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
