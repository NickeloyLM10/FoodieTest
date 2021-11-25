package com.example.foodie.meal.repository

import com.example.foodie.meal.model.MealResponse
import com.example.foodie.meal.service.IMealService
import javax.inject.Inject

interface IMealRepository {
    suspend fun getAllMeals() : MealResponse
}

class MealRepository @Inject constructor(
    val service: IMealService
) : IMealRepository {
    override suspend fun getAllMeals(): MealResponse {
        return service.getAllMeals()
    }
}