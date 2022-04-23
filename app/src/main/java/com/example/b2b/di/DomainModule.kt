package com.example.b2b.di

import com.example.b2b.model.MapDomainToApp
import com.example.domain.repository.Repository
import com.example.domain.usecases.FetchUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideFetchItemsUseCase(repository: Repository): FetchUseCase =
        FetchUseCase.Base(repository = repository)

    @Provides
    fun provideMapDomainToApp(): MapDomainToApp =
        MapDomainToApp.BaseMapDomainToApp()
}