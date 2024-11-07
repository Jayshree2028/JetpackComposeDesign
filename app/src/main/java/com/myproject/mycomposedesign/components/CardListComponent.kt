package com.myproject.mycomposedesign.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.myproject.mycomposedesign.R
import com.myproject.mycomposedesign.model.CardElements

@Composable
fun CardListComponent() {
    val cardDataList = listOf(
        CardElements(R.drawable.image1, "Horizon", "Forbidden West"),
        CardElements(R.drawable.image2, "God of War", " Ragnarök"),
        CardElements(R.drawable.image3, "Elden Ring", ""),
        CardElements(R.drawable.image4, "Destiny", "The Witch Queen")

    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(cardDataList) { cardDataList ->
            CardWithImageDesign(
                image = cardDataList.image,
                title = cardDataList.title,
                subTitle = cardDataList.subTitle
            )
        }
    }
}

@Preview
@Composable
fun CardListComponentPrev() {
    CardListComponent()
}