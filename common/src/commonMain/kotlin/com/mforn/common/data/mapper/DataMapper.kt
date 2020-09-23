package com.mforn.common.data.mapper


interface DataMapper<in I, out O> {

    fun mapToDomain(data: I): O

}