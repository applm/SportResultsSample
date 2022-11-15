package com.mappl.sportresultsample.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.mappl.model.SportResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

sealed interface SportResultListUiState {
    object Loading : SportResultListUiState
    data class Success(val sportResults: List<SportResult>) : SportResultListUiState
}

class SportResultsListViewModel : ViewModel() {

    // Expose screen UI state
    private val _uiState = MutableStateFlow(SportResultListUiState.Loading)
    val uiState: StateFlow<SportResultListUiState> = _uiState.asStateFlow()

}