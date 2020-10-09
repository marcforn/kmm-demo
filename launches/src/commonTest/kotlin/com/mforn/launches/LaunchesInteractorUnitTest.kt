package com.mforn.launches

import com.mforn.launches.domain.interactor.LaunchesInteractor
import com.mforn.launches.domain.interactor.LaunchesInteractorImpl
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals


class LaunchesInteractorUnitTest {

    private lateinit var launchesInteractor: LaunchesInteractor


    @BeforeTest
    fun setup(){
        launchesInteractor = LaunchesInteractorImpl()
    }

    @Test
    fun testSum() {
        assertEquals(3, 1+2)
    }

}