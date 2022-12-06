package com.mappl.data.sportresults

import android.util.Log
import com.mappl.core.network.GraphQLApi
import com.mappl.model.SportResult
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.merge
import javax.inject.Inject

/**
 * Refresher rate in milliseconds for the remote sport results.
 */
private const val REFRESH_DELAY = 5000L

/**
 * Repository for the sport results.
 */
class SportResultsRepository @Inject constructor(
    private val sportResultsRemote: GraphQLApi //todo use interface
) {
    //  val sportResultsLocal = todo()

    val periodicalRefreshSportResultsStream: Flow<List<SportResult>> = flow {
        while (true) {
            try {
                emit(sportResultsRemote.getSportResults())
            } catch (e: Exception) {
                Log.e("SportResultsRepository", "Error while fetching sport results", e)
            }
            delay(REFRESH_DELAY)
        }
    }

    private val remoteSportResultOnDemandStream = MutableStateFlow<List<SportResult>>(emptyList())

    val remoteSportResultsStream: Flow<List<SportResult>> = merge(
        periodicalRefreshSportResultsStream,
        remoteSportResultOnDemandStream
    ).conflate()

    suspend fun addSportResult(duration: String, name: String, place: String) {
        sportResultsRemote.addSportResult(duration, name, place)
        remoteSportResultOnDemandStream.value = sportResultsRemote.getSportResults()
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