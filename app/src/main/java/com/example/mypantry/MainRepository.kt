package com.example.mypantry

import android.util.Log
import retrofit2.Call

class MainRepository constructor(private val retrofitService: RetrofitService) {

    suspend fun getAllIngredients() : IngredientsResponse {
        Log.d("getAllIngredients", "called")
            return retrofitService.getAllIngredients()
    }
}