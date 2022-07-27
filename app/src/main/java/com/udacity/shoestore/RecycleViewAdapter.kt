package com.udacity.shoestore

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.udacity.shoestore.databinding.SingleItemBinding
import com.udacity.shoestore.models.Shoe

class RecycleViewAdapter(
    private var shoeList: List<Shoe>) : RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>() {

    // create an inner class with name ViewHolder
    // It takes a view argument, in which pass the
    // generated class of single_item.xml
    // ie SingleItemBinding and in the
    // RecyclerView.ViewHolder(binding.root) pass it like this
    inner class ViewHolder(val binding: SingleItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SingleItemBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
        return ViewHolder(binding)
    }

    // bind the items with each item of
    // the list languageList which than will be
    // shown in recycler view
    // to keep it simple we are not
    // setting any image data to view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(shoeList[position]) {
                // set text to  name
                binding.textName.text = this.name
                // set exp
                binding.textSize.text = this.size.toString()

                binding.textCompany.text=this.company

                binding.textDescription.text=this.description
            }
        }
    }

    // return the size of languageList
    override fun getItemCount(): Int {
        return shoeList.size
    }
}
