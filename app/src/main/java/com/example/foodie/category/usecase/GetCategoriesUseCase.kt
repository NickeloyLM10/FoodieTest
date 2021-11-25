package com.example.foodie.category.usecase

import com.example.foodie.category.model.CategoryResponse
import com.example.foodie.category.repository.ICategoryRepository
import javax.inject.Inject

interface IGetCategoriesUseCase {
    suspend operator fun invoke(): CategoryResponse
}

class GetCategoriesUseCase @Inject constructor(
    val repo: ICategoryRepository
) : IGetCategoriesUseCase {
    override suspend fun invoke(): CategoryResponse {
        return repo.getAllCategories()
    }
}