package com.mappl.core.network

import com.apollographql.apollo3.ApolloClient
import com.mappl.model.SportResult
import com.mappl.sportresultsample.core.network.GetListOfSportResultsQuery
import javax.inject.Inject

/**
 * Interface to the GraphQL API queries and mutations.
 */
class GraphQLApi @Inject constructor(private val apolloClient: ApolloClient) : SportResultsApi {

    // // TODO: Provide via DI
    // val apolloClient = ApolloClient.Builder()
    //     .serverUrl(LOCALHOST)
    //     .build()

    override suspend fun getSportResults(): List<SportResult> {
        apolloClient.query(GetListOfSportResultsQuery()).execute().let { response ->
            if (response.hasErrors()) {
                throw Exception("Error while fetching sport results: ${response.errors}")
            }
            return response.data?.listSportResults?.map { sportResult ->
                SportResult(
                    uid = sportResult.uid,
                    name = sportResult.name,
                    place = sportResult.place,
                    duration = sportResult.duration
                )
            } ?: emptyList()
        }
    }
}