package com.mappl.data.sportresults

import android.util.Log
import com.mappl.core.network.GraphQLSportResultsDataSource
import com.mappl.model.SportResult
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.single
import javax.inject.Inject

/**
 * Refresher rate in milliseconds for the remote sport results.
 */
private const val REFRESH_DELAY = 5000L

/**
 * Repository for the sport results.
 */
class SportResultsRepository @Inject constructor(
    private val sportResultsRemote: GraphQLSportResultsDataSource //todo use interface
) {
    //  val sportResultsLocal = todo()

    private val periodicalRefreshSportResultsStream: Flow<List<SportResult>> = flow {
        while (true) {
            try {
                emit(sportResultsRemote.getSportResults().single())
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

    /**
     * Create flow that adds a sport result to the remote database and update list flow.
     *
     * @param duration duration of the sport result
     * @param name name of the sport result
     * @param place place of the sport result
     * @return uid of the newly created sport result
     */
    fun addSportResultFlow(duration: String, name: String, place: String): Flow<String> {
        return sportResultsRemote.addSportResult(duration, name, place).flatMapLatest {
            remoteSportResultOnDemandStream.value = sportResultsRemote.getSportResults().single()
            flow { emit(it.uid) }
        }
    }
}