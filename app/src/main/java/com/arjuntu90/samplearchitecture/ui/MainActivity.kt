package com.arjuntu90.samplearchitecture.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.arjuntu90.samplearchitecture.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var weatherAdap:WeatherRvAdap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
            .apply {
                viewModel = this@MainActivity.viewModel
                lifecycleOwner = this@MainActivity
            }
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {
        weatherAdap = WeatherRvAdap()
        binding.rvWeather.run {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = weatherAdap
        }

        viewModel.weatherData.observe(this, {
            weatherAdap.submitList(it)
        })

        viewModel.loading.observe(this, {
            binding.pb.visibility = if (it) View.VISIBLE else View.GONE
        })

        viewModel.toast.observe(this, {
            Toast.makeText(this,it,Toast.LENGTH_LONG).show()
        })
    }
}