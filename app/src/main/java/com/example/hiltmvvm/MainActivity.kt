package com.example.hiltmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.hiltmvvm.viewmodels.MainViewmodels
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewmodels


    private val products: TextView
        get() = findViewById(R.id.products)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel= ViewModelProvider(this).get(MainViewmodels::class.java)
        mainViewModel.productlivedata.observe(this, Observer {
            products.text =  it.joinToString { x -> x.title + "\n\n" }
        })

    }
}