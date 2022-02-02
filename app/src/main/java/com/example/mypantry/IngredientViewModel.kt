package com.example.mypantry

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import okhttp3.Call
import retrofit2.Callback
import retrofit2.Response

class IngredientViewModel constructor(private val repository: MainRepository)  : ViewModel() {

    val ingredientList = MutableLiveData<IngredientsResponse>()
    val errorMessage = MutableLiveData<String>()

    suspend fun getAllIngredients() {
        ingredientList.postValue(repository.getAllIngredients())
        Log.d("nestonesto", "neenenene")
    }
//        val response = repository.getAllIngredients()
////        ingredientList.postValue(repository.getAllIngredients())
//        response.enqueue(object : Callback<ArrayList<IngredientsResponse>> {
//            override fun onResponse(
//                call: retrofit2.Call<ArrayList<IngredientsResponse>>,
//                response: Response<ArrayList<IngredientsResponse>>
//            ) {
//                Log.d("onResponse", "nesto nesto")
//            }
//
//            override fun onFailure(call: retrofit2.Call<ArrayList<IngredientsResponse>>, t: Throwable) {
//                Log.d("onFailure", "nesto nesto")
//            }
//
//        })
//    }

}