package com.udacity.shoestore

import android.util.Log
import androidx.lifecycle.ViewModel

class ShoeDetailsViewModel : ViewModel() {

    lateinit var name: String
    var size: Double = 0.0
    lateinit var company: String
    lateinit var description: String

    init {
        Log.i("ShoeDetailsViewModel","ShoeListViewModel Created")


    }

    override fun onCleared() {
        super.onCleared()
        Log.i("ShoeDetailsViewModel","ShoeListViewModel destroyed")

    }

}