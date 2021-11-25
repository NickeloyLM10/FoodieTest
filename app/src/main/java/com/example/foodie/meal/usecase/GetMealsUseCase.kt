package com.example.foodie.meal.usecase

import com.example.foodie.meal.model.MealResponse
import com.example.foodie.meal.repository.IMealRepository
import javax.inject.Inject

interface IGetMealsUseCase {

    suspend operator fun invoke(): MealResponse

}

class GetMealsUseCase @Inject  constructor(
    val repo : IMealRepository
) : IGetMealsUseCase {

    override suspend fun invoke(): MealResponse {
        return repo.getAllMeals()

    }
}