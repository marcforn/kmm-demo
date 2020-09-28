package com.mforn.rockets.data.network.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RocketDto(
    @SerialName("rocket_id")
    val id: String,
    @SerialName("rocket_name")
    val name: String,
    @SerialName("boosters")
    val boosters: Int,
    @SerialName("cost_per_launch")
    val cost: Int,
    @SerialName("success_rate_pct")
    val successRate: Int,
    @SerialName("flickr_images")
    val images: List<String>
)