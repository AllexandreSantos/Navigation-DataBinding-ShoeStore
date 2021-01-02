package com.udacity.shoestore.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoeViewModel
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding

    private val viewModel by activityViewModels<ShoeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)

        binding.cancelButton.setOnClickListener { view: View ->
            view.findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        }

        binding.shoeDetail = this

//        binding.saveButton.setOnClickListener { view: View ->
//            view.findNavController()
//                .navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
//        }

        // Inflate the layout for this fragment
        return binding.root
    }

    fun saveShoe(){

        val shoe = Shoe()

        shoe.name = binding.shoeNameEditText.text?.toString()
        shoe.company = binding.shoeCompanyEditText.text?.toString()
        shoe.description = binding.shoeDescriptionEditText.text?.toString()
        if (!binding.shoeSizeEditText.text?.toString().isNullOrEmpty()){
            shoe.size = binding.shoeSizeEditText.text?.toString()?.toDouble()
        }
        viewModel.addShoe(shoe)

        navigate()
    }

    private fun navigate(){
        view?.findNavController()
            ?.navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
    }


    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.findItem(R.id.loginFragment).isVisible = false
    }

}