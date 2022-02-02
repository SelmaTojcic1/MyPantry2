package com.example.mypantry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mypantry.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: IngredientViewModel
    private val retrofitService = RetrofitService.getInstance()
    private val adapter = IngredientAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this,
            MyViewModelFactory(MainRepository(retrofitService))).get(IngredientViewModel::class.java)

        binding.recyclerview.adapter = adapter

        viewModel.ingredientList.observe(this, Observer {
            adapter.setIngredientList(it.results)
        })

        viewModel.errorMessage.observe(this, Observer {

        })

//       viewModel.getAllIngredients()

        CoroutineScope(Dispatchers.IO).launch {
            viewModel.getAllIngredients()
        }
    }
}