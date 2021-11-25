package com.example.foodie.category.repository

import com.example.foodie.category.model.CategoryResponse
import com.example.foodie.category.service.ICategoryService
import javax.inject.Inject

interface ICategoryRepository {
    suspend fun getAllCategories(): CategoryResponse
}

class CategoryRepository @Inject constructor(
    val service: ICategoryService
) : ICategoryRepository {
    override suspend fun getAllCategories(): CategoryResponse {
        return service.getAllcategories() //getAllcategories() is suspend function coroutine...Suspend function 'getAllcategories' should be called only from a coroutine or another suspend function
    }
}