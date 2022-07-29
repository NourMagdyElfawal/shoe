package com.udacity.shoestore

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class MainActivityViewModel:ViewModel() {
    val shoeName = MutableLiveData<String>()
    val shoeCompany = MutableLiveData<String>()
    val shoeSize = MutableLiveData<String>()
    val shoeDescription = MutableLiveData<String>()
//    val shoe=MutableLiveData<Shoe>()
    // Instance of Shoe data class.
     val shoe: Shoe = Shoe("shoeName",40.0,"shoeCompany","shoeDescription")
     val shoe1: Shoe = Shoe("shoeName1",30.0,"shoeCompany1","shoeDescription1")
     val shoe2: Shoe = Shoe("shoeName2",37.0,"shoeCompany2","shoeDescription2")
     val shoe3: Shoe = Shoe("shoeName3",38.0,"shoeCompany3","shoeDescription3")

    init {

    }

}