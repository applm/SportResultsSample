package com.mappl.core.network

import com.apollographql.apollo3.ApolloClient
import com.mappl.model.SportResult
import com.mappl.sportresultsample.core.network.AddSportResultMutation
import com.mappl.sportresultsample.core.network.GetListOfSportResultsQuery
import com.mappl.sportresultsample.core.network.type.SportResultInput
import javax.inject.Inject
import kotlin.time.Duration

/**
 * Interface to the GraphQL API queries and mutations.
 */
class GraphQLApi @Inject constructor(private val apolloClient: ApolloClient) : SportResultsApi {

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

    override suspend fun addSportResult(duration: String, name: String, place: String) {
        apolloClient.mutation(AddSportResultMutation(SportResultInput(duration, name, place))).execute().let { response ->
            if (response.hasErrors()) {
                throw Exception("Error while adding sport result: ${response.errors}")
            }
        }
    }
}