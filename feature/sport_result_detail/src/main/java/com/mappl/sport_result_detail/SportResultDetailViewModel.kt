package com.mappl.sport_result_detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SportResultDetailViewModel @Inject constructor() : ViewModel() {
    var name by mutableStateOf("")
        private set

    var place by mutableStateOf("")
        private set

    var duration by mutableStateOf("")
        private set

    fun updateName(name: String) {
        this.name = name
    }

    fun updatePlace(place: String) {
        this.place = place
    }

    fun updateDuration(duration: String) {
        this.duration = duration
    }

    fun onSaveClicked() {
        //TODO
    }
}