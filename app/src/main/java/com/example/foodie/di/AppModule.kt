package com.example.foodie.di

import androidx.compose.ui.layout.ScaleFactor
import com.example.foodie.category.repository.CategoryRepository
import com.example.foodie.category.repository.ICategoryRepository
import com.example.foodie.category.service.ICategoryService
import com.example.foodie.category.usecase.GetCategoriesUseCase
import com.example.foodie.category.usecase.IGetCategoriesUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton


    @Module
    @InstallIn(SingletonComponent::class)
    class AppModule {

        @Provides
        @Singleton
        fun provideRetrofit() : Retrofit{
            return Retrofit.Builder()
                .baseUrl("https://www.themealdb.com/api/json/v1/1/")
                //.addConverterFactory(ScalarsConverterFactory.create()) //ScalarsConverterFactory.create() will take http req and turn ot onto something(string)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        @Provides
        @Singleton
        fun providesCategoryService(retrofit: Retrofit) : ICategoryService{
            return retrofit.create(ICategoryService::class.java)
        }

        @Module
        @InstallIn(SingletonComponent::class)
        interface AppModuleInt{
        @Binds
        @Singleton
        fun provideCategoryRepository(repo: CategoryRepository): ICategoryRepository

        @Binds
        @Singleton
        fun provideGetCategoryUseCase(uc: GetCategoriesUseCase): IGetCategoriesUseCase

    }

}