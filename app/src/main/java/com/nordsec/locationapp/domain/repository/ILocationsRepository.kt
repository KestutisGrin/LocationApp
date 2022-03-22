package com.nordsec.locationapp.domain.repository

import com.nordsec.locationapp.domain.entity.Location
import com.nordsec.locationapp.domain.entity.Locations
import io.reactivex.rxjava3.core.Observable

interface ILocationsRepository {
    fun getLocationsSortedByDistance(location: Location): Observable<Locations>
    fun getLocationsSortedByCityName(): Observable<Locations>
}