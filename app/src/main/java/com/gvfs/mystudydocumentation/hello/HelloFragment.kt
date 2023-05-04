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
import com.google.android.material.snackbar.Snackbar
import com.gvfs.mystudydocumentation.R
import com.gvfs.mystudydocumentation.databinding.FragmentHelloBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel

@AndroidEntryPoint
class HelloFragment : Fragment() {

    private val viewModel: HelloViewModel by viewModels()
    private val args: HelloFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentHelloBinding.inflate(inflater, container, false)
            .apply {
                viewModel = this@HelloFragment.viewModel
                lifecycleOwner = this@HelloFragment
            }
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btn = view.findViewById<Button>(R.id.btn_call_good_morning)
        btn.setOnClickListener {
            view.findNavController().navigate(R.id.action_helloFragment_to_goodMorningFragment)
        }
        viewModel.findName(args.myArg1)

        viewModel.events.observe(viewLifecycleOwner) { event ->
            when (event) {
                is HelloEvent.UserNotFound -> {
                    Snackbar.make(view, event.message, Snackbar.LENGTH_LONG).show()
                }
            }
        }
    }


}