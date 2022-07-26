package com.example.shoestore.shoelist

import android.util.Log
import androidx.lifecycle.ViewModel

class ShoeListViewModel:ViewModel() {
    init {
        Log.i("ShoeListViewModel","ShoeListViewModel Created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("ShoeListViewModel","ShoeListViewModel destroyed")

    }
}