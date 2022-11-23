package com.mappl.core.network.di

import com.mappl.core.network.GraphQLApi
import com.mappl.core.network.SportResultsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    fun provideSportResultsApi(): SportResultsApi = GraphQLApi()
}