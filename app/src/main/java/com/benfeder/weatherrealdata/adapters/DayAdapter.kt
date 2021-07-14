package com.benfeder.weatherrealdata.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.benfeder.weatherrealdata.R
import com.benfeder.weatherrealdata.holders.DayHolder
import com.benfeder.weatherrealdata.model.Hourly
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class DayAdapter(private val list : List<Hourly>) : RecyclerView.Adapter<DayHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.day_view, parent, false)
        return DayHolder(view)
    }

    override fun onBindViewHolder(holder: DayHolder, position: Int) {
        val reformatTime = getDateTime(list[position].dt.toString())
        holder.dayTimeHolder.text = reformatTime
        holder.dayTempHolder.text = list[position].temp.toString()
    }

    private fun getDateTime(s: String): String? {
        return try {
            val sdf = SimpleDateFormat("HH:mm")
            val netDate = Date(s.toLong() * 1000 )
            sdf.format(netDate)
        } catch (e: Exception) {
            e.toString()
        }
    }

    override fun getItemCount() = list.size
}