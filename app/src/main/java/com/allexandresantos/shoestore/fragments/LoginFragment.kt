package com.allexandresantos.shoestore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.allexandresantos.shoestore.R
import com.allexandresantos.shoestore.databinding.FragmentLoginBinding

class LoginFragment: Fragment(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_login, container, false)

        binding.existingLoginButton.setOnClickListener { view:View->
            view.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()) }
        binding.newLoginButton.setOnClickListener {view:View->
            view.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())  }


        return binding.root
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.findItem(R.id.loginFragment).isVisible = false
    }
}