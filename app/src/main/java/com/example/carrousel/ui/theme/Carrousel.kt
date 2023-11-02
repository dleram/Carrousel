package com.example.carrousel.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.foundation.text.KeyboardType
//import androidx.compose.foundation.text.TextFieldValue
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap.Companion.Square
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carrousel.R


@Composable
fun Carousel(images: List<Int>, texts: List<String>, fechas: List<String>, onIndexChanged: (Int) -> Unit) {
    var index by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = images[index]),
            contentDescription = null,
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
                .fillMaxHeight(0.8f),
            contentScale = ContentScale.Fit
        )


        Box(
            modifier = Modifier
                .weight(1f)
                .padding(5.dp)

                .background(color = Color.Gray),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = texts[index],
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier.padding(8.dp)

            )
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .padding(5.dp)

                .background(color = Color.Gray),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = fechas[index],
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier.padding(8.dp)

            )
        }


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
                    .size(35.dp)
                    .background(color = Color.DarkGray),
                contentAlignment = Alignment.Center
            ) {
                IconButton(
                    onClick = {
                        val newIndex = (index - 1 + images.size) % images.size
                        index = newIndex
                        onIndexChanged(newIndex)
                    }
                ) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null, tint = Color.White)
                }
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
                    .size(35.dp)
                    .background(color = Color.DarkGray),
                contentAlignment = Alignment.Center
            ) {
                IconButton(
                    onClick = {
                        val newIndex = (index + 1) % images.size
                        index = newIndex
                        onIndexChanged(newIndex)
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
        }
    }
}

@Composable
fun CarouselPreview() {
    val images = listOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3
    )

    val texts = listOf(
        "El Grito",
        "Guernica",
        "La Noche Estrellada"
    )

    val fechas = listOf(
        "Edvard Munch 1843",
        "Pablo Picasso 1937",
        "Vincent Van Gogh 1889"
    )


    Carousel(images, texts, fechas) { }
}



