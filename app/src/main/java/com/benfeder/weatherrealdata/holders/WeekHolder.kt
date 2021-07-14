package com.benfeder.weatherrealdata.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.benfeder.weatherrealdata.R
import com.google.android.material.textview.MaterialTextView

class WeekHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var weekDayHolder = itemView.findViewById<MaterialTextView>(R.id.week_day_holder)
    var weekLowHolder = itemView.findViewById<MaterialTextView>(R.id.week_low_holder)
    var weekHighHolder = itemView.findViewById<MaterialTextView>(R.id.week_high_holder)
}