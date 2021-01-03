package com.allexandresantos.shoestore.fragments

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.allexandresantos.shoestore.R
import com.allexandresantos.shoestore.ShoeViewModel
import com.allexandresantos.shoestore.databinding.FragmentShoeDetailBinding
import com.allexandresantos.shoestore.models.Shoe

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding

    private val viewModel by activityViewModels<ShoeViewModel>()

    private val shoe = Shoe()

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

        binding.shoeDetailFragment = this
        binding.shoeObject = shoe

        // Inflate the layout for this fragment
        return binding.root
    }

    fun saveShoe(){
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