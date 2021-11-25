package com.example.foodie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.foodie.category.CategoryScreen
import dagger.hilt.android.AndroidEntryPoint
import com.example.foodie.ui.theme.FoodieTheme as FoodieTheme1

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodieTheme1 {
                FoodieApp()
            }
        }
    }
}

@Composable
fun FoodieApp() {
    CategoryScreen()
}
