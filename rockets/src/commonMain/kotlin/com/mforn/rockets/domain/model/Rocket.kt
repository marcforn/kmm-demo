package com.mforn.rockets.domain.model

data class Rocket(
    val id: String,
    val name: String,
    val boosters: Int,
    val cost: Int,
    val successRate: Int,
    val images: List<String>
)
