package com.example.foodie.di

import androidx.compose.ui.layout.ScaleFactor
import com.example.foodie.meal.repository.IMealRepository
import com.example.foodie.meal.repository.MealRepository
import com.example.foodie.meal.service.IMealService
import com.example.foodie.meal.usecase.GetMealsUseCase
import com.example.foodie.meal.usecase.IGetMealsUseCase
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
        fun providesCategoryService(retrofit: Retrofit) : IMealService{
            return retrofit.create(IMealService::class.java)
        }

        @Module
        @InstallIn(SingletonComponent::class)
        interface AppModuleInt{
        @Binds
        @Singleton
        fun provideCategoryRepository(repo: MealRepository): IMealRepository

        @Binds
        @Singleton
        fun provideGetCategoryUseCase(uc: GetMealsUseCase): IGetMealsUseCase

    }

}