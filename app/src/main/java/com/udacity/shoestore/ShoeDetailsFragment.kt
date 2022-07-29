package com.udacity.shoestore

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.shoestore.shoelist.ShoeListViewModel
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.fragment_shoe_details.*

class ShoeDetailsFragment : Fragment() {

    companion object {
        fun newInstance() = ShoeDetailsFragment()
    }

    private lateinit var viewModel: ShoeDetailsViewModel
    private lateinit var viewModelMain: MainActivityViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentShoeDetailsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_details, container, false
        )
//        val shoeModel = Shoe()
//        searchHomeModel.word = jsonObject1.getString("word")

        viewModelMain = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        binding.viewModel = viewModelMain
        binding.lifecycleOwner = this


        Log.i("ShoeDetailsViewModel","ViewModelProvider")
        viewModel = ViewModelProvider(this).get(ShoeDetailsViewModel::class.java)

        binding.buttonCancel.setOnClickListener { v: View ->
            v.findNavController()
                .navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShowListFragment())
        }
        binding.buttonSave.setOnClickListener { v: View ->
            viewModel.name = editTextName.text.toString()
            var sizeText=editTextSize.text.toString()
            if (sizeText.isNotEmpty())
            viewModel.size = sizeText.toDouble()
            viewModel.company = editTextCompany.text.toString()
            viewModel.description = editTextDescription.text.toString()


            val shoe=Shoe(viewModel.name,viewModel.size,viewModel.company,viewModel.description)

            Log.i("shoe", shoe.toString())

            v.findNavController()
                .navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShowListFragment(shoe))
        }

        setHasOptionsMenu(true)
        return binding.root
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ShoeDetailsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}