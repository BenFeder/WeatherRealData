package com.benfeder.weatherrealdata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.benfeder.weatherrealdata.adapters.DayAdapter
import com.benfeder.weatherrealdata.adapters.WeekAdapter
import com.benfeder.weatherrealdata.databinding.FragmentMainBinding
import com.benfeder.weatherrealdata.repository.Repository
import com.benfeder.weatherrealdata.viewmodel.WeatherFactory
import com.benfeder.weatherrealdata.viewmodel.WeatherViewModel

class MainFragment : Fragment(R.layout.fragment_main) {

    private lateinit var viewModel : WeatherViewModel
//    private var navController: NavController? = null
    private var _binding : FragmentMainBinding? = null
    private val binding : FragmentMainBinding
        get() = _binding!!

    private lateinit var dayRecycler : RecyclerView
    private lateinit var weekRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val repository = Repository()
        val viewModelFactory = WeatherFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(WeatherViewModel::class.java)
        viewModel.getWeeklyWeather()
        viewModel.getData().observe(viewLifecycleOwner, { weatherData ->
//            Log.d("Fragment", weatherData.body()?.current?.weather[0].main)
            binding.city.text = weatherData.body()?.timezone!!.split("/")[1]
            binding.clarity.text = weatherData.body()?.current!!.weather[0].main
            binding.high.text = "H:${(weatherData.body()?.current!!.temp + 5.0)}"
            binding.low.text = "H:${(weatherData.body()?.current!!.temp - 5.0)}"
            binding.currentTemp.text = "${weatherData.body()?.current!!.temp}"
            dayRecycler.adapter = DayAdapter(weatherData.body()?.hourly!!)
            weekRecyclerView.adapter = WeekAdapter(weatherData.body()?.daily!!)
        })
//        navController = Navigation.findNavController(view)
        dayRecycler = view.findViewById(R.id.day_recycler)
        weekRecyclerView = view.findViewById(R.id.week_recycler)
        dayRecycler.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        weekRecyclerView.layoutManager = LinearLayoutManager(activity)
//        day recycler adapter set up
//        week recycler adapter set up

    }
}