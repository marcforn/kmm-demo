package com.mforn.launches.domain.model

data class RocketLaunch(
    val flightNumber: Int,
    val missionName: String,
    val launchYear: Int,
    val details: String,
    val launchSuccess: Boolean,
)
