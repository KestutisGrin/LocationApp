package com.nordsec.locationapp.data.repository

import android.util.Log
import com.google.gson.Gson
import com.nordsec.locationapp.App
import com.nordsec.locationapp.domain.entity.Location
import com.nordsec.locationapp.domain.entity.Locations
import com.nordsec.locationapp.domain.repository.ILocationsRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.concurrent.Callable


/*
* The class Location repository to read location data and return parsed data
*
* The function getLocationsSortedByDistance should return list of location sorted
* by set custom location (user can choose any location)
*
* The function getLocationsSortedByDistance should rerun list of location sorted by city name
*
*/

open class LocationsRepository : ILocationsRepository, AbstractRepository() {

    override fun getLocationsSortedByDistance(location: Location): Observable<Locations> {
        return Observable.fromCallable { locations }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    }

    override fun getLocationsSortedByCityName(): Observable<Locations> {
        return Observable.fromCallable { locations }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}