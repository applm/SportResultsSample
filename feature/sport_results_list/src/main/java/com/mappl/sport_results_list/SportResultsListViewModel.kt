package com.mappl.sport_results_list

import androidx.lifecycle.ViewModel
import com.mappl.data.sportresults.SportResultsRepository
import com.mappl.model.SportResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

sealed interface SportResultListUiState {
    object Loading : SportResultListUiState
    data class Success(val sportResults: List<SportResult>) : SportResultListUiState
}

@HiltViewModel
class SportResultsListViewModel @Inject constructor(
    val sportResultsListRepository: SportResultsRepository
) : ViewModel() {

    // Expose screen UI state
    private val _uiState = MutableStateFlow(SportResultListUiState.Loading)
    val uiState: StateFlow<SportResultListUiState> = _uiState.asStateFlow()

}