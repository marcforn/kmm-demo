package com.mforn.kmmdemo.androidApp

import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.mforn.bluetooth.domain.model.Peripheral
import com.mforn.common.configuration.log.CustomLogger
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@ExperimentalStdlibApi
class MainActivity : AppCompatActivity(), OnClickItemListener {

    private val mainScope = MainScope()

    private lateinit var launchesRecyclerView: RecyclerView
    private lateinit var progressBarView: FrameLayout
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    private val launchesRvAdapter = MainAdapter(listOf(), this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        launchesRecyclerView = findViewById(R.id.launchesListRv)
        progressBarView = findViewById(R.id.progressBar)
        swipeRefreshLayout = findViewById(R.id.swipeContainer)

        launchesRecyclerView.adapter = launchesRvAdapter
        launchesRecyclerView.layoutManager = LinearLayoutManager(this)

        swipeRefreshLayout.setOnRefreshListener {
            swipeRefreshLayout.isRefreshing = false
            displayLaunches()
        }

        displayLaunches()
        findBluetoothPeripherals()
    }

    override fun onDestroy() {
        super.onDestroy()
        mainScope.cancel()
    }

    private fun displayLaunches() {
        progressBarView.isVisible = true
        mainScope.launch {
            kotlin.runCatching {
                sdkManager.provideLaunches().getLaunches()
            }.onSuccess {
                launchesRvAdapter.dataset = it
                launchesRvAdapter.notifyDataSetChanged()
                progressBarView.isVisible = false
            }.onFailure {
                Toast.makeText(this@MainActivity, it.localizedMessage, Toast.LENGTH_LONG).show()
                progressBarView.isVisible = false
            }
        }
    }

    private fun findBluetoothPeripherals() {
        mainScope.launch {
            kotlin.runCatching {
                sdkManager.provideBluetooth().getPeripherals()
            }.onSuccess {
                CustomLogger.d("MFR", "${it.size} devices found")
                it.forEach { item -> CustomLogger.d("MFR", "UUID: ${item.uuid} -- Name: ${item.name}") }
            }.onFailure {
                Toast.makeText(this@MainActivity, it.localizedMessage, Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onClickItem(flightNumber: Int) {
        progressBarView.isVisible = true
        mainScope.launch {
            kotlin.runCatching {
//                sdkManager.provideLaunches().getLaunchInformation(flightNumber)
                val peripheral = Peripheral("98:09:CF:67:CC:1E", "OnePlus 7")
                sdkManager.provideBluetooth().connectPeripheral(peripheral)
                delay(5000)
                sdkManager.provideBluetooth().disconnectPeripheral(peripheral)
            }.onSuccess {
                progressBarView.isVisible = false
            }.onFailure {
                Toast.makeText(this@MainActivity, it.localizedMessage, Toast.LENGTH_LONG).show()
                progressBarView.isVisible = false
            }
        }
    }

}