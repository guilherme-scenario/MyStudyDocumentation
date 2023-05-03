package com.gvfs.mystudydocumentation.bye

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.gvfs.mystudydocumentation.R
import com.gvfs.mystudydocumentation.databinding.FragmentByeBinding
import com.gvfs.mystudydocumentation.hello.HelloFragmentDirections

class ByeFragment : Fragment() {

    private val viewModel: ByeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        FragmentByeBinding.inflate(inflater, container, false).apply {
            return root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentByeBinding.bind(view)

        binding.btnCallInit.setOnClickListener {
            view.findNavController().navigate(
                ByeFragmentDirections.actionByeFragmentToHelloFragment(binding.textInputBye.text.toString())
            )
        }
    }

}