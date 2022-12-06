package com.mappl.sport_result_detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import com.mappl.data.sportresults.SportResultsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
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

    fun updateName(name: String) {
        this.name = name
    }

    fun updatePlace(place: String) {
        this.place = place
    }

    fun updateDuration(duration: String) {
        this.duration = duration
    }

    fun onSaveClicked(lifecycleOwner: LifecycleOwner) {
        lifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
            sportResultsListRepository.addSportResult(
                name = name,
                place = place,
                duration = duration
            )
        }
    }
}