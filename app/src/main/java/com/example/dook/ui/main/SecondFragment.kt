package com.example.dook.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.dook.databinding.SecondFragmentBinding

class SecondFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var binding: SecondFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SecondFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

}