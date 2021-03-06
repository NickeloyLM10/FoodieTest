package com.example.foodie.category.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.Recomposer
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodie.category.model.Category
import com.example.foodie.category.usecase.IGetCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    useCase: IGetCategoriesUseCase
) : ViewModel() {

    private val _listOfCategories: MutableState<List<Category>> = mutableStateOf(emptyList())
    val listOfCategories: State<List<Category>> = _listOfCategories //cant write to it only can read it (immutable)

    init {
        viewModelScope.launch {
            val categoriesList = useCase()
            _listOfCategories.value = categoriesList.categories
        }

    }

}