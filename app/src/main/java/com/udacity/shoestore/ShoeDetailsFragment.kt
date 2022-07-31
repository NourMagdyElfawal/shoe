package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding



class ShoeDetailsFragment : Fragment() {

    private lateinit var mainViewModel: MainActivityViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentShoeDetailsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_details, container, false)
//we use requireActivity instead of this
// to sea data viewModel throw the activity
        mainViewModel = ViewModelProvider(requireActivity()).
        get(MainActivityViewModel::class.java)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.mainViewModel = mainViewModel

        mainViewModel.isShoeAdded.observe(viewLifecycleOwner) { isAdded ->
            if (isAdded) {
                //go to shoeListFragment
                findNavController().navigateUp()
                mainViewModel.onAddShoe()
            }
        }

        binding.buttonCancel.setOnClickListener {
            findNavController().navigateUp()
        }

        return binding.root
    }




}