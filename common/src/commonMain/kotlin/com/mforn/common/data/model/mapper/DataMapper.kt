package com.mforn.common.data.model.mapper


interface DataMapper<in I, out O> {

    fun mapToDomain(data: I): O

}