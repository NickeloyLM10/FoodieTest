package com.example.foodie.category.service

import com.example.foodie.category.model.CategoryResponse
import retrofit2.http.GET

interface ICategoryService {

    @GET("categories.php")
    suspend fun getAllcategories(): CategoryResponse //suspend makes asynchronous network req (coroutines)

}

//categories.php