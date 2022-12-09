package com.mappl.sport_result_detail

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mappl.data.sportresults.SportResultsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SportResultDetailViewModel @Inject constructor(
    private val sportResultsListRepository: SportResultsRepository
) : ViewModel() {
    var name by mutableStateOf("")
        private set

    var place by mutableStateOf("")
        private set

    var duration by mutableStateOf("")
        private set

    var isSaving by mutableStateOf(false)
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

    fun onSaveClicked(onSaved: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            isSaving = true
            val uid = sportResultsListRepository.addSportResultFlow(
                name = name,
                place = place,
                duration = duration
            ).single()
            isSaving = false
            Log.d("SportResults", "Sport result saved with uid: $uid")
            withContext(Dispatchers.Main) {
                onSaved()
            }
        }
    }
}