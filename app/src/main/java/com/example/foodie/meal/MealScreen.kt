package com.example.foodie.meal

import android.text.Layout
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.foodie.meal.model.Meal
import com.example.foodie.meal.viewmodel.MealViewModel

@Composable
fun MealScreen(
    viewmodel : MealViewModel = hiltViewModel()
) {

    val listOfMeals by remember {
        viewmodel.listOfMeals
    }

    Column {
        Text("Meals", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(30.dp))
        LazyColumn {
            items(listOfMeals){ item->
                SingleMealItem(item)

            }
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun SingleMealItem(
    meal: Meal
) {
    Card(modifier = Modifier.padding(8.dp).fillMaxWidth(), elevation = 8.dp) {
        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                modifier = Modifier.size(80.dp), painter = rememberImagePainter(
                    meal.strMealThumb
                ), contentDescription = null)
            Text(text = meal.strMeal, fontSize = 18.sp)
        }

    }

    
}