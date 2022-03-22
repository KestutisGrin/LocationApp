package com.nordsec.locationapp.data.repository

import com.google.gson.Gson
import com.nordsec.locationapp.App
import com.nordsec.locationapp.domain.entity.Locations
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

abstract class AbstractRepository {
    private val inputStream: InputStream = App.context.assets.open("data.json")
    private val bufferReader = BufferedReader(InputStreamReader(inputStream))
    val locations: Locations = Gson().fromJson(bufferReader, Locations::class.java)
}