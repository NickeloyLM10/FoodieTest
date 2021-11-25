package com.example.foodie.meal.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodie.meal.model.Meal
import com.example.foodie.meal.usecase.IGetMealsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealViewModel @Inject constructor(
    val useCase: IGetMealsUseCase
) : ViewModel(){


    private val _listOfMeals: MutableState<List<Meal>> = mutableStateOf(emptyList())
    val listOfMeals: State<List<Meal>> = _listOfMeals

    init {
        viewModelScope.launch {
            val mealsList = useCase()
            _listOfMeals.value=mealsList.meals
        }
    }
}