package com.example.foodie.meal.service

import com.example.foodie.meal.model.MealResponse
import retrofit2.http.GET

interface IMealService {
    @GET("filter.php?c=dessert")
    suspend fun getAllMeals(): MealResponse
}

//https://www.themealdb.com/api/json/v1/1/filter.php?c=dessert