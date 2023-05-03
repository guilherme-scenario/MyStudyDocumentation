package com.gvfs.mystudydocumentation.goodmorning

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.gvfs.mystudydocumentation.R
import com.gvfs.mystudydocumentation.databinding.FragmentGoodMorningBinding

class GoodMorningFragment : Fragment() {

    private val viewModel: GoodMorningViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        FragmentGoodMorningBinding.inflate(inflater, container, false).apply {
            return root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentGoodMorningBinding.bind(view).btnCallBye.setOnClickListener {
            view.findNavController().navigate(R.id.action_goodMorningFragment_to_byeFragment)

        }
    }

}