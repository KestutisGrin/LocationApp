package com.nordsec.locationapp.domain.usecase.location

import com.nordsec.locationapp.domain.entity.Location
import com.nordsec.locationapp.domain.entity.Locations
import com.nordsec.locationapp.domain.repository.ILocationsRepository
import io.reactivex.rxjava3.core.Observable

class GetLocationsUseCase(private val repo: ILocationsRepository) {

    fun getLocationsSortedByDistance(location: Location): Observable<Locations> {
        return repo.getLocationsSortedByDistance(location)
    }

    fun getLocationsSortedByCityName(): Observable<Locations> {
        return repo.getLocationsSortedByCityName()
    }
}