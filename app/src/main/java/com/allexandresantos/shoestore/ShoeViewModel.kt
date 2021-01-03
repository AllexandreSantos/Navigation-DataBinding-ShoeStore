package com.allexandresantos.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.allexandresantos.shoestore.models.Shoe

class ShoeViewModel: ViewModel() {

    private val _shoeList = MutableLiveData<ArrayList<Shoe>>()

    val shoeList: LiveData<ArrayList<Shoe>>
        get() = _shoeList

    init {
        _shoeList.value = ArrayList()
    }

    fun addShoe(shoe: Shoe){
        _shoeList.value?.add(shoe)
    }

    fun getShoeList(): ArrayList<Shoe>? {
        return _shoeList.value
    }

}