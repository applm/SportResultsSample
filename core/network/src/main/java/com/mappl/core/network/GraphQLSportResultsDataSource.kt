package com.mappl.core.network

import com.apollographql.apollo3.ApolloClient
import com.mappl.model.SportResult
import com.mappl.sportresultsample.core.network.AddSportResultMutation
import com.mappl.sportresultsample.core.network.GetListOfSportResultsQuery
import com.mappl.sportresultsample.core.network.type.SportResultInput
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Implementation of GraphQL API queries and mutations.
 */
class GraphQLSportResultsDataSource @Inject constructor(private val apolloClient: ApolloClient) : SportResultsDataSource {

    override fun getSportResults(): Flow<List<SportResult>> {
        return apolloClient.query(GetListOfSportResultsQuery()).toFlow().map { response ->
            if (response.hasErrors()) {
                throw Exception("Error while fetching sport results: ${response.errors}")
            }
            response.data?.listSportResults?.map { sportResult ->
                SportResult(
                    sportResult.uid,
                    sportResult.duration,
                    sportResult.name,
                    sportResult.place
                )
            } ?: emptyList()
        }
    }

    override fun addSportResult(duration: String, name: String, place: String) : Flow<SportResult> {
        return apolloClient.mutation(AddSportResultMutation(SportResultInput(duration, name, place)))
            .toFlow().map { response ->
            if (response.hasErrors()) {
                throw Exception("Error while adding sport result: ${response.errors}")
            } else {
                SportResult(
                    uid = response.data?.addSportResult?.uid ?: "",
                    name = name,
                    place = place,
                    duration = duration
                )
            }
        }
    }
}