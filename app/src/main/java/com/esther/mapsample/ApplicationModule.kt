package com.esther.mapsample

import com.esther.mapsample.model.TransitMockData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    fun transitMockDataProvider(): TransitMockData {
        return TransitMockData()
    }
}