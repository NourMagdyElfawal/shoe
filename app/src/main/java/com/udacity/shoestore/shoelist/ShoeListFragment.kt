package com.udacity.shoestore.shoelist

import com.udacity.shoestore.RecycleViewAdapter
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.shoestore.shoelist.ShoeListViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ShowListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShowListFragment : Fragment() {
    // TODO: Rename and change types of parameters

    private lateinit var viewModel: ShoeListViewModel
    // get reference to the adapter class
    private var shoeList = ArrayList<Shoe>()
    private lateinit var recycleViewAdapter: RecycleViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("ShoeListViewModel","ViewModelProvider")
        viewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)
        // Inflate the layout for this fragment
        val binding: FragmentShoeListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_list, container, false)
        binding.fab.setOnClickListener { v: View ->
            v.findNavController().navigate(ShowListFragmentDirections.actionShowListFragmentToShoeDetailsFragment())
        }

        // define layout manager for the Recycler view
//        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // attach adapter to the recycler view and also handle item click

        // attach adapter to the recycler view
        recycleViewAdapter = RecycleViewAdapter(shoeList)

        // add adapter to the recycler view
        binding.recyclerView.adapter = recycleViewAdapter


        // create objects of Language
        // create some row data
        val shoe1 = Shoe("shoe1", 499.0,"comp1","des1")
        val shoe2 = Shoe("shoe2",366.0 ,"comp2","des2")
        val shoe3 = Shoe("shoe3",566.0,"comp3","des3")
        val shoe4 = Shoe("shoe4",766.9 ,"comp4","des4")
        val shoe5 = Shoe("shoe5", 744.9,"comp5","des5")

        // pass raw data t rhe list
        shoeList.add(shoe1)
        shoeList.add(shoe2)
        shoeList.add(shoe3)
        shoeList.add(shoe4)
        shoeList.add(shoe5)
        shoeList.add(shoe3)
        shoeList.add(shoe4)
        shoeList.add(shoe5)
        shoeList.add(shoe3)
        shoeList.add(shoe4)
        shoeList.add(shoe5)

        recycleViewAdapter.notifyDataSetChanged()




        val args = ShowListFragmentArgs.fromBundle(requireArguments())
        Log.i("shoeList", args.shoe.toString())
        val newShoe=args.shoe
        if (newShoe != null) {
            shoeList.add(newShoe)
            recycleViewAdapter.notifyDataSetChanged()

        }


        setHasOptionsMenu(true)
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ShowListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ShowListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}