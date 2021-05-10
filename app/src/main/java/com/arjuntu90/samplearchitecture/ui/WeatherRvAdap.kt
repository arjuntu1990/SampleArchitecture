package com.arjuntu90.samplearchitecture.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.arjuntu90.logic.db.WeatherItem
import com.arjuntu90.samplearchitecture.databinding.ItemRvWeatherBinding

class WeatherRvAdap : ListAdapter<WeatherItem, WeatherRvAdap.WeatherVH>(WeatherDiffUtil) {
    class WeatherVH(private val binding: ItemRvWeatherBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(weatherItem: WeatherItem) {
            binding.apply {
                item = weatherItem
                executePendingBindings()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherVH {
        return WeatherVH(
            ItemRvWeatherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: WeatherVH, position: Int) {
        holder.bind(getItem(position))
    }
}

object WeatherDiffUtil : DiffUtil.ItemCallback<WeatherItem>() {
    override fun areItemsTheSame(oldItem: WeatherItem, newItem: WeatherItem) =
        oldItem.timepoint == newItem.timepoint

    override fun areContentsTheSame(oldItem: WeatherItem, newItem: WeatherItem) = oldItem == newItem
}