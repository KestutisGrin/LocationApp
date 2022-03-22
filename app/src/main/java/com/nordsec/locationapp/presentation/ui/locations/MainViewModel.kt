package com.nordsec.locationapp.presentation.ui.locations

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nordsec.locationapp.domain.entity.Location
import com.nordsec.locationapp.domain.entity.Locations
import com.nordsec.locationapp.domain.usecase.location.GetLocationsUseCase
import io.reactivex.rxjava3.core.Observable

/*
*
* MainViewModel to fetch repository data and display for view
*
*/
class MainViewModel(private val getLocationsUseCase: GetLocationsUseCase): ViewModel() {

    val locationList = MutableLiveData<List<Location>>()
    val error = MutableLiveData<String>()

    fun getLocationsSortedByDistance(location: Location) {
        getLocationsUseCase.getLocationsSortedByDistance(location).subscribe({ locations ->
            locationList.postValue(locations.location.sortedBy { it.latitude < location.latitude && it.longitude < location.longitude })
        }, {
            error.postValue(it.message)
        })
    }

    fun getLocationsSortedByCityName() {
        getLocationsUseCase.getLocationsSortedByCityName().subscribe({ locations ->
            locationList.postValue(locations.location.sortedBy { it.city })
        }, {
            error.postValue(it.message)
        })
    }
}