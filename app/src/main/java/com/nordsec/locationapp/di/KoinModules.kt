package com.nordsec.locationapp.di

import com.nordsec.locationapp.data.repository.LocationsRepository
import com.nordsec.locationapp.domain.repository.ILocationsRepository
import com.nordsec.locationapp.domain.usecase.location.GetLocationsUseCase
import com.nordsec.locationapp.presentation.ui.locations.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    single { GetLocationsUseCase(get()) }
}

val repositoryModule = module {
    single<ILocationsRepository> { LocationsRepository() }
}

val viewModelModule = module {
    viewModel { MainViewModel(get())}
}

val koinModules = useCaseModule + repositoryModule + viewModelModule