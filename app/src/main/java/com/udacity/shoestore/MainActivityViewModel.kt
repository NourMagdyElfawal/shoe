package com.udacity.shoestore

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class MainActivityViewModel: ViewModel() {


    var shoe: MutableLiveData<Shoe>

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    private val _isShoeAdded = MutableLiveData<Boolean>()
    val isShoeAdded: LiveData<Boolean>
        get() = _isShoeAdded
    init {
    // initiate shoeAdded flag
    _isShoeAdded.value = false
    // and shoeList
    _shoeList.value = ArrayList()
        // make the shoe model empty value
        shoe = MutableLiveData<Shoe>(Shoe("", 0.0, "", "", mutableListOf()))
    }
// we call this function when we click saveButton at shoe details fragment
    fun addShoe(shoe: Shoe) {
        //return the current value and add new shoe
        _shoeList.value?.add(shoe)
        //make the flag true
        _isShoeAdded.value = true
    }
// this fun after we add the new value
    fun onAddShoe() {
    //make  the flag false
        _isShoeAdded.value = false
    //set  the shoe constructor empty to avoid duplicate
        shoe.value = Shoe("", 0.0, "", "", mutableListOf())
    }
}