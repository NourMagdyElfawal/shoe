package com.udacity.shoestore.shoelist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.MainActivityViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.SingleShoeBinding
import com.udacity.shoestore.models.Shoe


class ShowListFragment : Fragment() {

//    private lateinit var viewModel: ShoeListViewModel
    private lateinit var mainViewModel: MainActivityViewModel
    private var shoeListLinearLayout: LinearLayout? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("ShoeListViewModel", "ViewModelProvider")


        // Inflate the layout for this fragment
        val binding: FragmentShoeListBinding =
            DataBindingUtil.inflate<FragmentShoeListBinding>(
            inflater, R.layout.fragment_shoe_list, container, false
        )

//        mainViewModel.shoeName.observe(viewLifecycleOwner, Observer {
////            textViewName.text = it.toString()
//            Toast.makeText(context,it,Toast.LENGTH_LONG).show()
//        })
        mainViewModel = ViewModelProvider(requireActivity()).get(MainActivityViewModel::class.java)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.mainViewModel = mainViewModel




        shoeListLinearLayout = binding.shoeListLinearLayout
        mainViewModel.shoeList
            .observe(viewLifecycleOwner) { shoeList ->
            Log.i("ShoeDetailsViewModel", shoeList.size.toString())
            shoeList.forEach { shoe ->
                Log.i("ShoeDetailsViewModel", shoe.toString())
                val listItemBinding = SingleShoeBinding.inflate(layoutInflater, null, false)
                listItemBinding.shoe = shoe
                binding.shoeListLinearLayout.addView(listItemBinding.root)
            }
        }



            binding.fab.setOnClickListener { v: View ->
                v.findNavController()
                    .navigate(ShowListFragmentDirections.actionShowListFragmentToShoeDetailsFragment())
            }

            setHasOptionsMenu(true)
            return binding.root
        }
}