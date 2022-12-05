package com.example.dook.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.dook.MainActivity
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.currentAstronomicPicture.observe(viewLifecycleOwner) { astronomicPicture ->
            Glide.with(binding.root)
                .load(astronomicPicture.url)
                .centerCrop()
                .into(binding.ivPicture)

            (requireActivity() as MainActivity).supportActionBar?.title = astronomicPicture.title
        }
    }
}