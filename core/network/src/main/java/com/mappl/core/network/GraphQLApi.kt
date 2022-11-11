package com.mappl.core.network

import com.apollographql.apollo3.ApolloClient

const val LOCALHOST = "http://127.0.0.1:8080"

/**
 * Interface to the GraphQL API queries and mutations.
 */
class GraphQLApi : SportResultsApi {

    // TODO: Provide via DI
    val apolloClient = ApolloClient.Builder()
        .serverUrl(LOCALHOST)
        .build()


}