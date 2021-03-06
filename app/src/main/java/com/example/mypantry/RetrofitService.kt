package com.example.mypantry

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {

//    @GET("food/ingredients")
//    fun getAllIngredients(): Call<ArrayList<Ingredient>>

    @GET("food/ingredients/search?query=banana&apiKey=d5e5abb43ff04413b72c202719110909")
    suspend fun getAllIngredients(): IngredientsResponse

    companion object {

        var retrofitService: RetrofitService? = null

        fun getInstance() : RetrofitService {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://api.spoonacular.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }

}