package com.mappl.core.network

import com.mappl.model.SportResult

/**
 * Api for remote sport results repository.
 */
interface SportResultsApi {
    /**
     * Get all sport results.
     */
    suspend fun getSportResults(): List<SportResult>

    /**
     * Add a sport result.
     */
    suspend fun addSportResult(duration: String, name: String, place: String)
}