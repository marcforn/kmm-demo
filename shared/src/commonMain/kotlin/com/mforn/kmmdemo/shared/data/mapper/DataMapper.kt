package com.mforn.kmmdemo.shared.data.mapper


interface DataMapper<out V, in D> {

    fun mapToDomain(data: D): V

}