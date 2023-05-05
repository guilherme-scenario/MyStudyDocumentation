package com.gvfs.mystudydocumentation.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.gvfs.mystudydocumentation.R
import com.gvfs.mystudydocumentation.alert.AlertEvent
import com.gvfs.mystudydocumentation.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentLoginBinding.inflate(inflater, container, false)
            .apply {
                viewModel = this@LoginFragment.viewModel
                lifecycleOwner = this@LoginFragment
            }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val emailField = view.findViewById<EditText>(R.id.form_login_email)
        val passwordField = view.findViewById<EditText>(R.id.form_login_password)
        val btn = view.findViewById<Button>(R.id.form_login_btn_submit)
        val btnRoute = view.findViewById<Button>(R.id.form_login_btn_route)

        btnRoute.setOnClickListener {
            view.findNavController().navigate(
                LoginFragmentDirections.actionLoginFragmentToHelloFragment(
                    emailField.text.toString()
                )
            )
        }


        btn.setOnClickListener {
            viewModel.findUser(emailField.text.toString(), passwordField.text.toString())

            viewModel.events.observe(viewLifecycleOwner) { event ->
                when (event) {
                    is AlertEvent.UserNotFound -> {
                        Snackbar.make(view, event.message, Snackbar.LENGTH_LONG).show()
                    }
                }
            }

            viewModel.user.observe(viewLifecycleOwner) { user ->
                if (user != null) {
                    view.findNavController().navigate(
                        LoginFragmentDirections.actionLoginFragmentToHelloFragment(emailField.text.toString())
                    )
                }

            }

        }


    }

}