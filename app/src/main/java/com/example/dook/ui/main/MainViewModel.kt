package com.example.dook.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dook.AstronomicPictures

class MainViewModel : ViewModel() {

    private var _currentAstronomicPicture: MutableLiveData<AstronomicPictures> = MutableLiveData()
    val currentAstronomicPicture: LiveData<AstronomicPictures> = _currentAstronomicPicture

    fun saveAstronomicPicture(astronomicPictures: AstronomicPictures) {
        _currentAstronomicPicture.value = astronomicPictures
    }
}