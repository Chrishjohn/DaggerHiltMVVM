package com.example.hiltmvvm.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hiltmvvm.models.Product
import com.example.hiltmvvm.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class MainViewmodels @Inject constructor(val repository: ProductRepository) : ViewModel() {
val productlivedata:LiveData<List<Product>>
get() = repository.product

    init {
        viewModelScope.launch {
            repository.getProducts()
        }
    }
}