package com.mappl.sport_results_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mappl.data.sportresults.SportResultsRepository
import com.mappl.model.SportResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface SportResultListUiState {
    object Loading : SportResultListUiState
    data class Success(val sportResults: List<SportResult>) : SportResultListUiState
}

@HiltViewModel
class SportResultsListViewModel @Inject constructor(
    private val sportResultsListRepository: SportResultsRepository
) : ViewModel() {

    // Expose screen UI state
    private val _uiState = MutableStateFlow<SportResultListUiState>(SportResultListUiState.Loading)
    val uiState: StateFlow<SportResultListUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            sportResultsListRepository.remoteSportResultsStream.collect { sportResults ->
                _uiState.value = SportResultListUiState.Success(sportResults)
            }
        }
    }

}