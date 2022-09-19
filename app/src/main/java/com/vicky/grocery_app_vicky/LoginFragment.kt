package com.vicky.grocery_app_vicky

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.vicky.grocery_app_vicky.databinding.FragmentLoginBinding
import com.vicky.grocery_app_vicky.singletons.VirtualDB

class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        VirtualDB.toString()
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.loginButton.setOnClickListener {
            validateLogin(it)
        }
        binding.singUpLink.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_signUpFragment)
        }
        return binding.root
    }


    private fun validateLogin(it: View?) {
        binding.apply {
            val email = emailTextInput.text.toString()
            val password = emailTextInput.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(context, "please complete all fields", Toast.LENGTH_LONG).show()
                return
            }
            if (it != null) {
                Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_homeFragment)
            }

        }
    }
}
