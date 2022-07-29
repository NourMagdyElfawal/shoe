package com.udacity.shoestore.shoelist

import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.widget.TextViewCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.shoestore.shoelist.ShoeListViewModel
import com.udacity.shoestore.MainActivityViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.fragment_instructions.*


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

    private lateinit var viewModel: ShoeListViewModel
    private lateinit var mainViewModel: MainActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("ShoeListViewModel","ViewModelProvider")

        viewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)
        mainViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        // Inflate the layout for this fragment
        val binding: FragmentShoeListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_list, container, false)
        binding.fab.setOnClickListener { v: View ->
            v.findNavController().navigate(ShowListFragmentDirections.actionShowListFragmentToShoeDetailsFragment())
        }

        binding.shoe = mainViewModel.shoe
        binding.shoe1 = mainViewModel.shoe1
        binding.shoe2 = mainViewModel.shoe2
        binding.shoe3 = mainViewModel.shoe3



        val args = ShowListFragmentArgs.fromBundle(requireArguments())
        Log.i("shoe", args.shoe.toString())
        val newShoe=args.shoe
        if (newShoe != null) {


            val linearLayout:LinearLayout = LinearLayout(context)
            // Creating a LinearLayout.LayoutParams object for LinearLayout
            var paramsLinearLayout : LinearLayout.LayoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, // This will define LinearLayout width
                LinearLayout.LayoutParams.WRAP_CONTENT// This will define LinearLayout height
            )
            linearLayout.layoutParams=paramsLinearLayout
            linearLayout.orientation = LinearLayout.VERTICAL

            // Create a new TextView instance programmatically
            val textViewName:TextView = TextView(context)
            val textViewCompany:TextView = TextView(context)
            val textViewSize:TextView = TextView(context)
            val textViewDescreption:TextView = TextView(context)

            // Creating a LinearLayout.LayoutParams object for text view
            var params : LinearLayout.LayoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, // This will define text view width
                LinearLayout.LayoutParams.WRAP_CONTENT// This will define text view height
            )
            // Add margin to the text view
            params.setMargins(10,10,10,10)

            // Now, specify the text view width and height (dimension)
            textViewName.layoutParams = params
            textViewCompany.layoutParams = params
            textViewSize.layoutParams = params
            textViewDescreption.layoutParams = params

            //set textview gravity
            textViewName.gravity=Gravity.CENTER_HORIZONTAL
            textViewCompany.gravity=Gravity.CENTER_HORIZONTAL
            textViewSize.gravity=Gravity.CENTER_HORIZONTAL
            textViewDescreption.gravity=Gravity.CENTER_HORIZONTAL

            // Display new shoe data
            textViewName.text = newShoe.name
            textViewCompany.text = newShoe.company
            textViewSize.text = newShoe.size.toString()
            textViewDescreption.text = newShoe.description

            //set text style
            TextViewCompat.setTextAppearance(textViewName, R.style.WhiteTextView)
            TextViewCompat.setTextAppearance(textViewCompany, R.style.WhiteTextView)
            TextViewCompat.setTextAppearance(textViewSize, R.style.WhiteTextView)
            TextViewCompat.setTextAppearance(textViewDescreption, R.style.WhiteTextView)


            //add text to the layout
            linearLayout.addView(textViewName)
            linearLayout.addView(textViewCompany)
            linearLayout.addView(textViewSize)
            linearLayout.addView(textViewDescreption)



            binding.linearLayoutMain.addView(linearLayout)

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