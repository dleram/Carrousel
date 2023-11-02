package com.example.carrousel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.carrousel.ui.theme.Carousel
import com.example.carrousel.ui.theme.CarouselPreview
import com.example.carrousel.ui.theme.CarrouselTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarrouselTheme {
                CarouselPreview()
            }
        }
    }
}

