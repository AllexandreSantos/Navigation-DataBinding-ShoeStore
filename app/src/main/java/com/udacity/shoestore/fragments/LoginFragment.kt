package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment: Fragment(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_login, container, false)

        //TODO: What is the difference between using binding.existingLoginButton (look the next TODO)
        binding.existingLoginButton.setOnClickListener { view:View->
            view.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()) }
        //TODO and this, not using binding:
        binding.newLoginButton.setOnClickListener {view:View->
            view.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())  }


        return binding.root
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.findItem(R.id.loginFragment).isVisible = false
    }
}