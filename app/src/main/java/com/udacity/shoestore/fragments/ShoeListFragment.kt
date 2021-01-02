package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoeViewModel
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.item_shoe.view.*

class ShoeListFragment : Fragment() {

    private val viewModel by activityViewModels<ShoeViewModel>()
    private lateinit var binding: FragmentShoeListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_shoe_list, container, false)

        binding.fab.setOnClickListener { view: View ->
            view.findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }

        observe()

        // Inflate the layout for this fragment
        return binding.root
    }

    private fun observe() {
        viewModel.shoeList.observe(viewLifecycleOwner, Observer { shoes ->
            shoes.forEach { addLayout(it) }
        })
    }

    private fun addLayout(shoe: Shoe){
        val shoeItemLayout = layoutInflater.inflate(R.layout.item_shoe, binding.shoeListLinearLayout, false)

//        val shoeName = toAdd.findViewById<TextView>(R.id.shoe_name_tv)
//        val shoeDescription = toAdd.findViewById<TextView>(R.id.shoe_description_tv)
//        val shoeSize = toAdd.findViewById<TextView>(R.id.shoe_size_tv)
//        val shoeCompany = toAdd.findViewById<TextView>(R.id.shoe_company_tv)
//
//        shoeName.text = shoe.name ?: ""
//        shoeCompany.text = shoe.company ?: ""
//        shoeSize.text = shoe.size?.toString() ?: ""
//        shoeDescription.text = shoe.description ?: ""

        shoeItemLayout.shoe_name_tv.text = shoe.name ?: ""
        shoeItemLayout.shoe_company_tv.text = shoe.company ?: ""
        shoeItemLayout.shoe_size_tv.text = shoe.size?.toString() ?: ""
        shoeItemLayout.shoe_description_tv.text = shoe.description ?: ""
        binding.shoeListLinearLayout.addView(shoeItemLayout)

    }

}