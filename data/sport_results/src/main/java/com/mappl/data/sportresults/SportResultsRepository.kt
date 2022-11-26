package com.mappl.data.sportresults

import com.mappl.core.network.GraphQLApi
import com.mappl.core.network.SportResultsApi
import com.mappl.model.SportResult
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Refresher rate in milliseconds for the remote sport results.
 */
private const val REFRESH_DELAY = 5000L

/**
 * Repository for the sport results.
 */
class SportResultsRepository @Inject constructor(
    private val sportResultsRemote: GraphQLApi
) {
    //  val sportResultsLocal = todo()

    // private val _remoteSportResultsStream = MutableStateFlow<List<SportResult>>(emptyList())
    // val remoteSportResultsStream = _remoteSportResultsStream.asStateFlow()
    //
    // suspend fun refresh() {
    //     _remoteSportResultsStream.value = sportResultsRemote.getSportResults()
    // }

    val remoteSportResultsStream: Flow<List<SportResult>> = flow {
        while (true) {
            emit(sportResultsRemote.getSportResults())
            delay(REFRESH_DELAY)
        }
    }

    // /**
    //  * Get all sport results from remote data source.
    //  */
    // fun getRemoteSportResults(): Flow<List<SportResult>> =
    //
    // /**
    //  * Get all sport results from local data source.
    //  */
    // fun getLocalSportResults(): Flow<List<SportResult>> = emptyList() // todo()
}