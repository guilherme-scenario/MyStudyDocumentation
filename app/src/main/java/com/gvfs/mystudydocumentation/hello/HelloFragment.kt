package com.gvfs.mystudydocumentation.hello

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.gvfs.mystudydocumentation.R
import com.gvfs.mystudydocumentation.databinding.FragmentHelloBinding

class HelloFragment : Fragment() {

    private val viewModel: HelloViewModel by viewModels()
    private val args: HelloFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hello, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentHelloBinding.bind(view)

        binding.btnCallGoodMorning.setOnClickListener {
            view.findNavController().navigate(R.id.action_helloFragment_to_goodMorningFragment)
        }
        binding.teste = args.myArg1
    }


}