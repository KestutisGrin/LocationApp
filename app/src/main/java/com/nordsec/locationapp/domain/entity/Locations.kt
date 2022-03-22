package com.nordsec.locationapp.domain.entity

import com.google.gson.annotations.SerializedName

data class Locations(@SerializedName("locations") val location: List<Location>)