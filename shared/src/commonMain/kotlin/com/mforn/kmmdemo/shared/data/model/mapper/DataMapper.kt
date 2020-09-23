package com.mforn.kmmdemo.shared.data.model.mapper


interface DataMapper<in I, out O> {

    fun mapToDomain(data: I): O

}