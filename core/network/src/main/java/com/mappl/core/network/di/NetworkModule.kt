package com.mappl.core.network.di

import com.apollographql.apollo3.ApolloClient
import com.mappl.core.network.GraphQLSportResultsDataSource
import com.mappl.core.network.SportResultsDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

const val LOCALHOST_FROM_EMULATOR = "http://10.0.2.2:8080/graphql"

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    fun provideSportResultsApi(apolloClient: ApolloClient): SportResultsDataSource = GraphQLSportResultsDataSource(apolloClient)

    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient = ApolloClient.Builder()
        .serverUrl(LOCALHOST_FROM_EMULATOR)
        .build()
}