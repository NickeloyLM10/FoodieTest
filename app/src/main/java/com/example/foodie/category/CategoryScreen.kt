package com.example.foodie.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.ElevationOverlay
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.foodie.category.model.Category
import com.example.foodie.category.viewmodel.CategoryViewModel

@Composable
fun CategoryScreen(
    viewmodel: CategoryViewModel = hiltViewModel()
) {

    val listOfCategories by remember {
        viewmodel.listOfCategories
    }


    Column {
        Text("What do you like!!!" , fontSize = 20.sp)
        Spacer(modifier = Modifier.height(30.dp))
        LazyColumn {
            items(listOfCategories) {item ->
                SingleCategoryItem(item)
                //run a composable funt inside here for every iteration of item that exists in listOfCategories
            }

        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun SingleCategoryItem(
    category : Category
) {
    Card (modifier = Modifier.padding(8.dp).fillMaxWidth(), elevation = 8.dp){
        Row (modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically){
            Image(modifier = Modifier.size(80.dp)
                ,painter = rememberImagePainter(
                    category.strCategoryThumb
                ), contentDescription = null)
            Text(text = category.strCategory , fontSize = 24.sp)
        }
    }
}

