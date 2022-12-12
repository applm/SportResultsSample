package com.mappl.core.network

import com.mappl.model.SportResult
import kotlinx.coroutines.flow.Flow

/**
 * Api for remote sport results repository.
 */
interface SportResultsDataSource {
    /**
     * Get all sport results.
     */
    fun getSportResults(): Flow<List<SportResult>>

    /**
     * Add a sport result.
     */
    fun addSportResult(duration: String, name: String, place: String): Flow<SportResult>
}