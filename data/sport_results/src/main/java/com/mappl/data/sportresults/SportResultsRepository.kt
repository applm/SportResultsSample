package com.mappl.data.sportresults

import com.mappl.core.network.GraphQLApi
import com.mappl.core.network.SportResultsApi
import com.mappl.model.SportResult

class SportResultsRepository {
    //TODO: Provide via DI
    private val sportResultsRemote = GraphQLApi()
    //  val sportResultsLocal = todo()

    /**
     * Get all sport results from remote data source.
     */
    suspend fun getRemoteSportResults(): List<SportResult> = sportResultsRemote.getSportResults()

    /**
     * Get all sport results from local data source.
     */
    suspend fun getLocalSportResults(): List<SportResult> = emptyList() // todo()
}