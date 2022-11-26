package com.mappl.core.network.di

import com.apollographql.apollo3.ApolloClient
import com.mappl.core.network.GraphQLApi
import com.mappl.core.network.SportResultsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

const val LOCALHOST = "http://127.0.0.1:8080"

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    fun provideSportResultsApi(apolloClient: ApolloClient): SportResultsApi = GraphQLApi(apolloClient)

    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient = ApolloClient.Builder()
        .serverUrl(LOCALHOST)
        .build()
}