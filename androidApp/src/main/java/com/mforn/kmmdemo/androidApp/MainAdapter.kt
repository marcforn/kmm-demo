package com.mforn.kmmdemo.androidApp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.mforn.launches.domain.model.Launch

class MainAdapter(
    var dataset: List<Launch>,
    private val onClickItemListener: OnClickItemListener
) : RecyclerView.Adapter<MainAdapter.LaunchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchViewHolder {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.item_launch, parent, false)
            .run(::LaunchViewHolder)
    }

    override fun getItemCount(): Int = dataset.count()

    override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) {
        holder.bindData(dataset[position])
    }

    inner class LaunchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val missionNameTextView = itemView.findViewById<TextView>(R.id.missionName)
        private val launchYearTextView = itemView.findViewById<TextView>(R.id.launchYear)
        private val launchSuccessTextView = itemView.findViewById<TextView>(R.id.launchSuccess)
        private val missionDetailsTextView = itemView.findViewById<TextView>(R.id.details)

        fun bindData(launch: Launch) {
            val ctx = itemView.context
            missionNameTextView.text = ctx.getString(R.string.mission_name_field, launch.missionName)
            launchYearTextView.text = ctx.getString(R.string.launch_year_field, launch.launchYear.toString())
            missionDetailsTextView.text = ctx.getString(R.string.details_field, launch.details ?: "")
            if (launch.launchSuccess) {
                launchSuccessTextView.text = ctx.getString(R.string.successful)
                launchSuccessTextView.setTextColor((ContextCompat.getColor(itemView.context, R.color.colorSuccessful)))
            } else {
                launchSuccessTextView.text = ctx.getString(R.string.unsuccessful)
                launchSuccessTextView.setTextColor((ContextCompat.getColor(itemView.context, R.color.colorUnsuccessful)))
            }

            itemView.setOnClickListener { onClickItemListener.onClickItem(launch.flightNumber) }
        }
    }
}

interface OnClickItemListener {
    fun onClickItem(flightNumber : Int)
}