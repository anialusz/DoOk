package com.example.dook.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dook.AstronomicPictures
import com.example.dook.NasaService
import com.example.dook.R
import com.example.dook.databinding.FirstFragmentBinding
import com.example.dook.network.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FirstFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var binding: FirstFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FirstFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.btnNavToFragment.setOnClickListener {
//            it.findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
//        }


        setUpRecyclerView()


    }


    private fun setUpRecyclerView() {
        binding.rvAstronomicPictureList.layoutManager = LinearLayoutManager(requireContext())

        GlobalScope.launch {

            val data =
                RetrofitHelper.getInstance().create(NasaService::class.java).getAstronomicPictures()

            withContext(Dispatchers.Main) {
                if (data.isSuccessful) {
                    val adapter = data.body()?.let { list ->
                        AstronomicAdapter(list) {
                            viewModel.saveAstronomicPicture(it)
                            navigateToDetailes(it)
                        }
                    }

                    binding.rvAstronomicPictureList.adapter = adapter
                }
            }
        }
    }

    fun navigateToDetailes(astronomicPicture: AstronomicPictures) {
        findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
    }
}