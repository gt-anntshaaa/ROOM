package com.example.roomandflow.ui.adapter

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.roomandflow.data.local.Schedule
import com.example.roomandflow.databinding.BusScheduleItemBinding

class ScheduleAdapter : ListAdapter<Schedule, ScheduleAdapter.ScheduleVH>(DiffCallback) {
    class ScheduleVH(private val binding: BusScheduleItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(schedule: Schedule){
            binding.tvStopNameItem.text = schedule.stopName
            binding.tvArrivalTimeItem.text = schedule.arrivalTime
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Schedule>() {
            override fun areItemsTheSame(oldItem: Schedule, newItem: Schedule): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Schedule, newItem: Schedule): Boolean {
                return oldItem == newItem
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = BusScheduleItemBinding.inflate(layoutInflater,parent,false)
        return ScheduleVH(view)
    }

    override fun onBindViewHolder(holder: ScheduleVH, position: Int) {
        holder.bind(getItem(position))
    }

}